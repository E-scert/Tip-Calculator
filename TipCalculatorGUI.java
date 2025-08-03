/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package titpcalaculatorgui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

/**
 *
 * @author JREscert
 */
public class TipCalculatorGUI extends JFrame{
    
    //panels 
    private JPanel headingPnl;
    private JPanel billAmountPnl;
    private JPanel tipAmountPnl;
    private JPanel tipPnl;
    private JPanel tipCombinedPnl;
    private JPanel mainPnl;
    
    //labels
    private JLabel headingLbl;
    private JLabel billAmountLbl;
    private JLabel tipAmountLbl;
    private JLabel tipLbl;
    
    //textField
    private JTextField billAmountTxt;
    private JTextField tipAmountTxt;
    private JTextField tipTxt;
    
    //scroll
    private JSlider tipSlider;
    
    public TipCalculatorGUI(){
        setTitle("Tip Calculator");
        setResizable(true);
        setSize(400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    
        //create panels 
        headingPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        billAmountPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        tipAmountPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        tipPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        tipCombinedPnl = new JPanel(new GridLayout(2,1,1,1));
        
        mainPnl = new JPanel(new GridLayout(4,0,0,0));
        
        ///create labels
        
        headingLbl = new JLabel("Tip Calculator");
        headingLbl.setFocusable(true);
        headingLbl.setFont(new Font(Font.SANS_SERIF,Font.BOLD + Font.ITALIC,35));
        
        billAmountLbl = new JLabel("Enter The Bill Amount For Your Meal:R");
        billAmountLbl.setFont(new Font(Font.DIALOG,Font.PLAIN, 15));
        
        tipAmountLbl = new JLabel("Tip Amount: ");
        tipAmountLbl.setFont(new Font(Font.DIALOG,Font.PLAIN, 15));
        
        tipLbl = new JLabel("Tip To Leave:");
        tipLbl.setFont(new Font(Font.SERIF,Font.BOLD, 20));
        
        //create Textspace
        
        billAmountTxt = new JTextField(12);
        billAmountTxt.setBorder(BorderFactory.createEtchedBorder());
        tipAmountTxt = new JTextField(3);
        tipAmountTxt.setBorder(null);
        tipTxt = new JTextField(10);
        tipTxt.setBorder(null);
        tipTxt.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        
        //create jslider
        tipSlider = new JSlider(1,100);
        
        
        //add panels
        
        headingPnl.add(headingLbl);
        billAmountPnl.add(billAmountLbl);
        billAmountPnl.add(billAmountTxt);
        
        tipAmountPnl.add(tipAmountLbl);
        tipAmountPnl.add(tipAmountTxt);
        tipAmountPnl.add(tipSlider);
        
        tipPnl.add(tipLbl);
        tipPnl.add(tipTxt);
        
        //tipCombinedPnl.add(billAmountPnl,BorderLayout.NORTH);
        //tipCombinedPnl.add(tipAmountPnl,BorderLayout.CENTER);
       // tipCombinedPnl.add(tipPnl, BorderLayout.NORTH);
        
        mainPnl.add(headingPnl,BorderLayout.NORTH);
        mainPnl.add(billAmountPnl,BorderLayout.SOUTH);
        mainPnl.add(tipAmountPnl,BorderLayout.SOUTH);
        mainPnl.add(tipPnl,BorderLayout.SOUTH);
        //mainPnl.add(tipPnl, BorderLayout.SOUTH);
        
        //add actionListener
        
            tipSlider.addChangeListener(l ->{
                int  bill = Integer.parseInt(billAmountTxt.getText());
                
                int percentage = tipSlider.getValue();                
                tipAmountTxt.setText(percentage+"%");
                
                double total =  (percentage * bill)/100;
                tipTxt.setText("R"+total);

            });
        
        
        
        add(mainPnl);
        pack();
        setVisible(true);
        
    
    }
    
}
