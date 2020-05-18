package lab12;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import lombok.Getter;


@Getter
public  class MainFrame extends JFrame{
	
	private ControlPanel controlPanel;
    DesignPanel designPanel;
    private ProprietiesPanel proprietiesPanel;
    private DesignPanel designPanel1;

    public MainFrame() {
        super("LAB12");
        init();
    }

    /**
     * Initialize the Mainframe Component
     * adding its children (panels)
     */
    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initPanels();
        addElementsInContainer();
        pack();
        designPanel1 = new DesignPanel();
    }

    private void initPanels() {
        controlPanel = new ControlPanel(this);
        designPanel = new DesignPanel(this, 800, 600);
        proprietiesPanel = new ProprietiesPanel(this);
        designPanel1 = new DesignPanel();
    }
    

    

	public ControlPanel getControlPanel() {
		return controlPanel;
	}

	public DesignPanel getDesignPanel() {
		return designPanel;
	}

	public ProprietiesPanel getProprietiesPanel() {
		return proprietiesPanel;
	}

	/**
     * arrange the components in the container (frame)
     * JFrame uses a BorderLayout by default
     */
    private void addElementsInContainer() {
        add(controlPanel, BorderLayout.NORTH);
        add(designPanel, BorderLayout.CENTER);
        add(proprietiesPanel, BorderLayout.WEST);
    }

    public void updateDesignPanel(DesignPanel designPanel) {
        remove(this.designPanel);
        this.designPanel = designPanel;
        
        add(designPanel, BorderLayout.CENTER);
        pack();
    }
    
    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }

	
}

