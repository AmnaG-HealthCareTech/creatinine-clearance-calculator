import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import javax.swing.*;

public class CreatClearanceCalc 
{
    /// age, weight, creatinine, gender, Antibiotics

    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Creatinine Clearance Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(100, 100);
        frame.setBounds(0, 0, 300, 500);
        frame.setLayout(null);

        JLabel AgeL = new JLabel("Age: ");
        AgeL.setBounds(25,25,250,30);
        frame.add(AgeL);


        JTextField AgeT = new JTextField();
        AgeT.setBounds(100,30,100,20);
        frame.add(AgeT);


        JLabel WeightL = new JLabel("Weight (kg): ");
        WeightL.setBounds(25,60,250,30);
        frame.add(WeightL);


        JTextField WeightT = new JTextField();
        WeightT.setBounds(100,65,100,20);
        frame.add(WeightT);


        JLabel CreatinineL = new JLabel("Creatinine: ");
        CreatinineL.setBounds(25,95,250,30);
        frame.add(CreatinineL);


        JTextField CreatinineT = new JTextField();
        CreatinineT.setBounds(100,100,100,20);
        frame.add(CreatinineT);


        JLabel GenderL = new JLabel("Gender: ");
        GenderL.setBounds(25,135,250,30);
        frame.add(GenderL);

        JComboBox GenderC = new JComboBox<>();
        GenderC.setBounds(100,140,100,20);
        GenderC.addItem("Male");
        GenderC.addItem("Female");
        GenderC.setSelectedIndex(0);
        frame.add(GenderC);

        JLabel CreatClearanceL = new JLabel("CrCl:");
        CreatClearanceL.setBounds(25,210,250,30);
        frame.add(CreatClearanceL);


        JTextField CreatClearanceT = new JTextField();
        CreatClearanceT.setBounds(100,215,100,20);
        CreatClearanceT.setEditable(false);
        frame.add(CreatClearanceT);

        JLabel HeightL = new JLabel("Height (cm): ");
        HeightL.setBounds(25,180,250,30);
        frame.add(HeightL);


        JTextField HeightT = new JTextField();
        HeightT.setBounds(100,185,100,20);
        frame.add(HeightT);

         JButton Calculate = new JButton("Calculate");
         Calculate.setBounds(100, 240, 100,20);
         frame.add(Calculate);

         Calculate.addActionListener(new ActionListener() 
         {
            public void actionPerformed(ActionEvent e)
            {
               Double height = Double.parseDouble(HeightT.getText());
               Double ibw;
               Double actualBodyWeight = Double.parseDouble(WeightT.getText());
               Double age = Double.parseDouble(AgeT.getText());
               Double creatinine = Double.parseDouble(CreatinineT.getText());
               Double CrCl;
               Double N;

                if(GenderC.getSelectedIndex()==0)
                {
                    ibw = 50 + (height-152);
                    N=1.23;
                }
                else  
                {
                    ibw = 45 + (height-152);
                    N=1.04;
                }

                if(actualBodyWeight>(1.2*ibw))
                {
                    CrCl = (N *(140-age)*ibw / creatinine);
                }
                else
                {
                    CrCl = (N *(140-age)*actualBodyWeight / creatinine);
                }
                CrCl = Math.round (CrCl*100.0)/100.0;
                CreatClearanceT.setText(""+ CrCl );
            }
         });

        JPanel AntibioticsP = new JPanel();
        AntibioticsP.setBounds(0,260,300,400);
        AntibioticsP.setBackground(Color.orange);
        AntibioticsP.setLayout(null);
        frame.add(AntibioticsP);

        JLabel AppropriateAnitbioticL = new JLabel("Determine appropriate antibiotic");
        AppropriateAnitbioticL.setBounds(50, -130, 300,300);
        AppropriateAnitbioticL.setForeground(Color.blue);
        AntibioticsP.add(AppropriateAnitbioticL);

       JLabel AntibioticL = new JLabel("Antibiotic:");
       AntibioticL.setBounds(25, -90, 300,300);
       AntibioticsP.add(AntibioticL);

       JTextField AntibioticT = new JTextField();
       AntibioticT.setBounds(100, 50, 100,20);
       AntibioticsP.add(AntibioticT);

       AntibioticT.addKeyListener(new KeyListener() 
       {
        public void keyPressed(KeyEvent e) 
        {
        }

        public void keyReleased(KeyEvent e) 
        {
            Double CrCl = Double.parseDouble(CreatClearanceT.getText()) ;

            if(AntibioticT.getText().equalsIgnoreCase("Doxycycline"))
            {
                AntibioticT.setBackground(Color.GREEN);
            }
            else if (CrCl<= 10 && AntibioticT.getText().equalsIgnoreCase("Tazocin"))
            {
                AntibioticT.setBackground(Color.red);
            }
            else if (CrCl<=30 && AntibioticT.getText().equalsIgnoreCase("Nitrofurantoin"))
            {
                AntibioticT.setBackground(Color.red);
            }
            else if (CrCl <=40  && AntibioticT.getText().equalsIgnoreCase("Nitrofurantoin"))
            {
                AntibioticT.setBackground(Color.yellow);
            }
            else if (CrCl >= 40 && AntibioticT.getText().equalsIgnoreCase("Nitrofurantoin"))
            {
                AntibioticT.setBackground(Color.green);
            }
            else
            {
                AntibioticT.setBackground(Color.white);
            }
        }

        public void keyTyped(KeyEvent e) 
        {
        }
       });

        frame.setVisible(true);
    }
}
