/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalpractice;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author leonguevara
 */
public class BMICalculator extends JFrame {
    public BMICalculator() {
        this.setTitle("BMI Calculator"); // Frame title
        this.setSize(500,300); // 500 px width x 300 px height
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to kill the app
        this.setLocationRelativeTo(null); // screen centered
        
        this.setLayout(new GridLayout(5, 1));
        
        JPanel heightPanel = new JPanel(); // panel for the first row
        heightPanel.add(new JLabel("Height (cm.):")); // label
        JTextField heightTF = new JTextField(10); // text field for height
        heightPanel.add(heightTF); // adding the text field to the panel
        
        JPanel weightPanel = new JPanel(); // panel for the second row
        weightPanel.add(new JLabel("Weight (kg.):")); // label
        JTextField weightTF = new JTextField(10); // text field for weight
        weightPanel.add(weightTF); // adding the text field to the panel
        
        JPanel bmiPanel = new JPanel();
        JLabel bmiLabel = new JLabel("BMI = ");
        bmiPanel.add(bmiLabel);
        
        JPanel computePanel = new JPanel();
        JButton computeBMI = new JButton("Compute BMI");
        computeBMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double height = Double.parseDouble(heightTF.getText().toString());
                    double weight = Double.parseDouble(weightTF.getText().toString());
                    double bmi = weight / (height * height);
                    bmiLabel.setText("BMI = " + String.valueOf(bmi));
                } catch (NumberFormatException ex) {
                    System.out.println("You must introduce numbers for height and weight");
                    System.out.println(ex.getMessage());
                } catch (ArithmeticException aex) {
                    System.out.println("Height cannot be 0!");
                    System.out.println(aex.getMessage());
                }
            }
        });
        computePanel.add(computeBMI);
        
        JButton cleanButton = new JButton("Clean and restart");
        cleanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                heightTF.setText("");
                weightTF.setText("");
                bmiLabel.setText("BMI = ");
            }
        });
        
        this.add(heightPanel); // adding the height panel to the frame
        this.add(weightPanel); // adding the weight panel to the frame
        this.add(computePanel); // adding the compute button
        this.add(bmiPanel); // adding the result label
        this.add(cleanButton); // adding the clean up button
        
        this.setVisible(true); // show the frame
    }
}
