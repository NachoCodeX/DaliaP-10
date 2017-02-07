package graphics;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Window extends JFrame implements ChangeListener,ActionListener,ListSelectionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel []panels;
	private JTabbedPane tab;
	private JButton btn;
	private JCheckBox []cbox;
	private JLabel label;	
	
	private ButtonGroup group;
	private JRadioButton[] rb;
	
	private JList<String>list;
	private String[]data={"Rojo","Verde","Azul"};
	private final static int WIDTH=800,HEIGHT=600;
	
	private JComboBox<String>com;
	
	
	private DefaultListModel<String >[]model;
	private JButton []b;
	
	
	
	
	public Window(){
		setWindow();
		init();
		addComponents();
	}
	
	private void setWindow(){
		this.setTitle("Dalia");
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
	
	
	
	@SuppressWarnings("unchecked")
	private void init(){
		panels=new JPanel[10];
		for(int i=0;i<panels.length;i++){panels[i]=new JPanel(null);}
		
		
		
		
		//P-1
		btn=new JButton("Aceptar");
		btn.addActionListener(this);
		cbox=new JCheckBox[3];
		
	
		label=new JLabel();
		
		//P-2
		group=new ButtonGroup();
		rb=new JRadioButton[3];
		
		for (int i = 0; i < cbox.length; i++) {
			rb[i]=new JRadioButton();rb[i].addActionListener(this);
			cbox[i]=new JCheckBox();cbox[i].addActionListener(this);
		}
		
		//P-3
		list=new JList<String>();
		list.setListData(data);
		list.addListSelectionListener(this);
		
		//P-4
		com=new JComboBox<String>();
		com.addItem(data[0]);
		com.addItem(data[1]);
		com.addItem(data[2]);
		com.addActionListener(this);
		
		//P-5
		model=new DefaultListModel[2];
		model[0]=new DefaultListModel<String>();
		model[0].addElement("Nacho");
		model[0].addElement("Victor");
		model[0].addElement("Chema");
		model[0].addElement("Julito");
		model[1]=new DefaultListModel<String>();
		model[1].addElement("Julian");
		model[1].addElement("Tavo");
		model[1].addElement("Angelito");
		
		b=new JButton[3];
		b[0]=new JButton("Curso 1");
		b[0].setBounds(0, 250, 100, 25);
		b[0].addActionListener(this);
		b[0].setActionCommand("Curso 1");
		b[1]=new JButton("Curso 2");
		b[1].setBounds(0, 300, 100, 25);
		b[1].addActionListener(this);
		b[1].setActionCommand("Curso 2");
		b[2]=new JButton("Vaciar");
		b[2].setBounds(250, 100, 100, 50);
		b[2].addActionListener(this);
		b[2].setActionCommand("Vaciar");
		tab=new JTabbedPane();	
		
		tab.addChangeListener(this);
		
		
		
		
	}
	
	private void addComponents(){
		//P-1
		for (int i = 0; i < cbox.length; i++) panels[0].add(cbox[i]);
	
		//P-2
		for (int i = 0; i < rb.length; i++){ 
			panels[1].add(rb[i]);
			group.add(rb[i]);
		}
		
		//P-3
		list.setBounds(0, 0, 200, 200);
		btn.setBounds(300, 0, 100, 24);
		panels[2].add(btn);
		
		
		//P-4
		com.setBounds(0, 0, 200, 23);
		panels[3].add(com);
		
		//P-5
		panels[4].add(b[0]);
		panels[4].add(b[1]);
		panels[4].add(b[2]);
		
		for(int i=0;i<panels.length;i++){tab.add("P-"+(i+1), panels[i]);}
		
		//Add JTabbedPane 
		this.add(tab);
	}

	
	
	private void setPractica(String ...args){
		label.setText("");
		for(int i=0;i<cbox.length;i++){cbox[i].setBounds(0, i*50, 100, 40);cbox[i].setText(args[i]); cbox[i].setActionCommand(args[i]);}
		label.setBorder(new TitledBorder(args[3]));
		label.setBounds(0, 150, 400, 100);
		panels[0].add(label);
	}
	
	private void setPractica2(String ...args){
		label.setText("");
		for (int i = 0; i < rb.length; i++) {rb[i].setText(args[i]); rb[i].setBounds(0, i*50, 100, 40);}
		label.setBorder(new TitledBorder(args[3]));
		panels[1].add(label);
	}
	
	private void setPractica3(){
	
		list.setListData(data);
		panels[2].add(list);
	}
	private void setPractica5(){
		list.setModel(new DefaultListModel<String>());
		panels[4].add(list);
		
		label.setText("");
		
		label.setBorder(new TitledBorder("Alumno"));
		
		label.setBounds(250, 0, 200, 50);
		
		panels[4].add(label);
	}
	

	
	@Override
	public void stateChanged(ChangeEvent e) {
		int x=tab.getSelectedIndex();
		if(x==0){
			setPractica("Perro","Gato","Raton","Animales");
			
		}else if(x==1){
			setPractica2("Rojo","Verde","Azul","Colores:");
		}else if(x==2){
			setPractica3();
		}
		
		else if(x==4){
			setPractica5();
		}
		
	}
	
	private void p1(){
		String mensaje="";
		if(cbox[0].isSelected()){mensaje+=" "+cbox[0].getActionCommand();
		}
		
		if(cbox[1].isSelected()){mensaje+=" "+cbox[1].getActionCommand();}
		
		if(cbox[2].isSelected()){mensaje+=" "+cbox[2].getActionCommand();}
		
		label.setText("Animales Seleccionados: "+mensaje);
	}	
	
	
	private void p2(){
		String mensaje="Color elegido: ";
		if(rb[0].isSelected())mensaje+=rb[0].getText();
		else if(rb[1].isSelected()) mensaje+=rb[1].getText();
		else if(rb[2].isSelected()) mensaje+=rb[2].getText();
		
		label.setText(mensaje);
	}
	
	private void p3(){
		label.setBorder(new TitledBorder("Colores: "));
		panels[2].add(label);
		label.setBounds(0, 250, 100, 100);
		label.setText("");
		label.setText(list.getSelectedValue());
	}

	private void p4(){
		label.setBorder(new TitledBorder("Colores: "));
		label.setText("");
		label.setBounds(0, 50, 100, 100);
		panels[3].add(label);
		label.setText(com.getSelectedItem().toString());
	}
	
	
	private void p5(String e){
		switch (e) {
			case "Curso 1":
				list.setModel(model[0]);;
				break;
			case "Curso 2":
				list.setModel(model[1]);
				break;
			case "Vaciar":
				list.setModel(new DefaultListModel<String>());
				break;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (tab.getSelectedIndex()) {
			case 0:
				p1();
				break;
			case 1:
				p2();
				break;
			case 2:
				p3();
				break;
			case 3:
				p4();
				break;
			case 4:
				p5(e.getActionCommand());
				break;
				
			
				
			
			
		
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(tab.getSelectedIndex()==4){
			label.setText(list.getSelectedValue());
		}
	}
	
	
	
	
	

}
