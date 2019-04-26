package manga;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class GUI extends JFrame implements ActionListener {

	private JPanel memoryPanel;
	private JPanel instructionPanel;
	private JPanel registerPanel;
	private JPanel inputPanel;
	private JScrollPane memoryScrollPane;
	private JTextArea textPane;
	private JPanel mainPanel;
	private JPanel mainmemoryPanel;
	private JPanel thumbRegisterPanel;
	private JScrollPane scrollPane;
	private JScrollPane imemoryScrollPane;
	private Container imemoryPanel;
	private JButton btnRun;

	public GUI() {
		getContentPane().setPreferredSize(new Dimension(800, 800));

		getContentPane().setLayout(new BorderLayout(0, 0));
		memoryPanel = new JPanel();
		mainmemoryPanel = new JPanel();
		mainmemoryPanel.setPreferredSize(new Dimension(200, 200));
		mainmemoryPanel.setLayout(new BorderLayout(0, 0));

		memoryScrollPane = new JScrollPane(memoryPanel);
		memoryScrollPane.setPreferredSize(new Dimension(400,200));
		memoryScrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		memoryScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		memoryPanel.setLayout(new BoxLayout(memoryPanel, BoxLayout.Y_AXIS));
		memoryScrollPane.setPreferredSize(new Dimension(200, 200));
		registerPanel = new JPanel();
		registerPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		registerPanel.setLayout(new BoxLayout(registerPanel, BoxLayout.Y_AXIS));
		thumbRegisterPanel = new JPanel();
		thumbRegisterPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		thumbRegisterPanel.setLayout(new BoxLayout(thumbRegisterPanel, BoxLayout.Y_AXIS));
		inputPanel = new JPanel();
		inputPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		inputPanel.setPreferredSize(new Dimension(300, 90));
		inputPanel.setLayout(null);
		mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(200, 40));
		getContentPane().add(mainmemoryPanel, BorderLayout.SOUTH);
		instructionPanel = new JPanel();
		instructionPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		instructionPanel.setLayout(new BoxLayout(instructionPanel, BoxLayout.Y_AXIS));
		imemoryPanel = new JPanel();
		imemoryScrollPane = new JScrollPane(imemoryPanel);
		imemoryScrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		imemoryScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		imemoryScrollPane.setPreferredSize(new Dimension(400,200));
		imemoryPanel.setLayout(new BoxLayout(imemoryPanel, BoxLayout.Y_AXIS));
		imemoryScrollPane.setPreferredSize(new Dimension(200, 200));

		mainmemoryPanel.add(memoryScrollPane, BorderLayout.WEST);
		mainmemoryPanel.add(imemoryScrollPane, BorderLayout.EAST);
		getContentPane().add(registerPanel, BorderLayout.CENTER);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setPreferredSize(new Dimension(200, 5));
		tabbedPane.add(instructionPanel);
		tabbedPane.add(thumbRegisterPanel);
		tabbedPane.setTitleAt(1, "Thumb");
		tabbedPane.setTitleAt(0, "Regular");
		getContentPane().add(tabbedPane, BorderLayout.EAST);
		getContentPane().add(inputPanel, BorderLayout.WEST);
		getContentPane().add(mainPanel, BorderLayout.NORTH);

		{
			instructionPanel.add(new JLabel("ADD   opcode:0000"));
			instructionPanel.add(new JLabel("MUL   opcode:0001"));
			instructionPanel.add(new JLabel("AND   opcode:0010"));
			instructionPanel.add(new JLabel("JR    opcode:0011"));
			instructionPanel.add(new JLabel("TCL   opcode:0100"));
			instructionPanel.add(new JLabel("ADDI  opcode:0101"));
			instructionPanel.add(new JLabel("PUSH  opcode:0110"));
			instructionPanel.add(new JLabel("LW    opcode:0111"));
			instructionPanel.add(new JLabel("SW    opcode:1000"));
			instructionPanel.add(new JLabel("SLL   opcode:1001"));
			instructionPanel.add(new JLabel("SLR   opcode:1010"));
			instructionPanel.add(new JLabel("JAL   opcode:1011"));
			instructionPanel.add(new JLabel("J     opcode:1100"));
			instructionPanel.add(new JLabel("BEQ   opcode:1101"));
			instructionPanel.add(new JLabel("LWRE  opcode:1110"));
			instructionPanel.add(new JLabel("LWRS  opcode:1111"));
		}
		{
			thumbRegisterPanel.add(new JLabel("HALT   opcode:0000"));
			thumbRegisterPanel.add(new JLabel("NOP   opcode:0001"));
			thumbRegisterPanel.add(new JLabel("RSP   opcode:0010"));
			thumbRegisterPanel.add(new JLabel("NTL    opcode:0011"));
			thumbRegisterPanel.add(new JLabel("CLR   opcode:0100"));
		}

		mainPanel.setLayout(null);

		JButton btnNewButton = new JButton("Compile");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = 0;
				
				for (String line : textPane.getText().split("\\n")) {
					datapathMain.InstructionMemory.write(line, index);
					index += 2;
				}
				refresh();
			}
		});
		btnNewButton.setBounds(12, 8, 97, 25);
		mainPanel.add(btnNewButton);
		
		btnRun = new JButton("Run");
		btnRun.setBounds(119, 8, 97, 25);
		mainPanel.add(btnRun);
		btnRun.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					datapathMain.main(null);
				} catch (InterruptedException e1) {
				
					e1.printStackTrace();
				}
				refresh();
			}
		});

		textPane = new JTextArea();
		textPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		textPane.setBounds(12, 13, 276, 534);
		inputPanel.add(textPane);
		refresh();
		pack();
		setVisible(true);
	}

	public void refresh() {
		memoryPanel.removeAll();
		registerPanel.removeAll();
		imemoryPanel.removeAll();
		int i = 0;
		int j = 0;
		for (String memo : datapathMain.datamemory.getMemory()) {
			memoryPanel.add(new JLabel(i + "    " + memo));
			i++;
			if (i == 100)
				break;
		}
		for (String memo : datapathMain.InstructionMemory.getMemory()) {
			imemoryPanel.add(new JLabel(j + "    " + memo));
			j++;
			if (j == 100)
				break;
		}
		for (Register reg : datapathMain.registerFile.getRegisterFile()) {
			registerPanel.add(new JLabel(reg.getName() + "    " + reg.getValue()));
		}
		repaint();
		revalidate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new GUI();
	}
}
