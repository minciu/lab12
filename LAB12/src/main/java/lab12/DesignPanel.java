package lab12;


import lombok.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



@NoArgsConstructor
public class DesignPanel extends JPanel implements Serializable{
	private MainFrame frame;
    @Getter
    private int width;
    @Getter
    private int height;
    
    private JTextField textField;
    List<JComponent> componentList;
    
    public List<JComponent> getComponentList() {
        return componentList;
    }
    
    public DesignPanel() {
        componentList = new ArrayList<>();
        setLayout(null);
    }

    public DesignPanel(MainFrame frame, int width, int height) {
        this.frame = frame;
        this.width = width;
        this.height = height;
        
        init();
    }

    public void setWidth(int width) {
        this.width = width;
        init();
    }

    public void setHeight(int height) {
        this.height = height;
        init();
    }

    private void init() {
        setPreferredSize(new Dimension(this.width, this.height));
    }

    public void addComponent(Component component) {	
    	add(component);   	    	            	
        revalidate();
        repaint();
    }

    
    /**
     * Whenever the user sets the focus on an added component,
     * its properties should be displayed in a JTable component
     */
    public void addFocusListenerToComponent(Component component) {
        component.addFocusListener(new FocusListener() {
        	@SneakyThrows
            @Override
            public void focusGained(FocusEvent e) {
        		
                Class<?> componentClass = component.getClass();
                BeanInfo info = null;
				try {
					info = Introspector.getBeanInfo(componentClass);
				} catch (IntrospectionException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                int i = 0;
                DefaultTableModel model = (DefaultTableModel) frame.getProprietiesPanel().getProprietiesTable().getModel();
                for (PropertyDescriptor propertyDescriptor : info.getPropertyDescriptors()) {
                    model.setValueAt(String.valueOf(propertyDescriptor.getPropertyType()), i, 0);
                    model.setValueAt(String.valueOf(propertyDescriptor.getName()), i, 1);
                    ++i;
                }
                
                
                
            }
        	
        	public void actionPerformed(ActionEvent e) {
        		((AbstractButton) component).setText("change");
        	}

            @Override
            public void focusLost(FocusEvent e) {
                // nothing
            }
        });
    }
    
    

	

}
