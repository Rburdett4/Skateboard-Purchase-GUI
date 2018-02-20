import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class SalesCalulator extends JFrame implements ActionListener
{
    static int WIDTH = 150;
    static int HEIGHT = 450;
    JFrame Cart = new JFrame("My Cart");
    FlowLayout flow = new FlowLayout();
    FlowLayout cartFlow = new FlowLayout();
    JLabel cartList = new JLabel();
    JComboBox pizzaBox = new JComboBox();
    JComboBox colorBox = new JComboBox();
    JLabel toppingList = new JLabel("Skateboard Type:");
    JLabel aLabel = new JLabel("Quantity:");
    JLabel firstlabel = new JLabel("Per-Board Price ");
    JLabel secondlabel = new JLabel("Per-Board Tax ");
    JLabel thirdlabel = new JLabel("Per-Board Total ");
    JLabel lastlabel = new JLabel("Total Price ");
    JTextField totalPriceField = new JTextField(10);
    JTextField taxPriceField = new JTextField(10);
    JTextField endPriceField = new JTextField(10);
    JTextField finalPriceField = new JTextField(10);
    JTextField quantityField = new JTextField(10);
    JButton calc = new JButton("Add to Cart");
    JButton clear = new JButton("Clear");
    JButton close = new JButton("Close");
    int[] pizzaPrice = {100, 75};
    int totalPrice = 0; 
    String output;
    String output2;
    String output3;
    String output4;
    double a; 
    int pizzaNum;
    int multiplier;
    JScrollPane scroll = new JScrollPane();
    public static void main(String[] arguments)
    {
        JFrame frame = new SalesCalulator();
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public SalesCalulator()
    {
        super("Ryan's Skateboard Shop");
        Cart.setSize(200, 400);
        Cart.setLocation(850, 300);
        Cart.setLayout(cartFlow);
        Cart.setVisible(true);
        Cart.setResizable(false);
        setLocation(600, 300);
        multiplier = 1;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Cart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(flow);
        pizzaBox = new JComboBox();
        calc.addActionListener(this);
        clear.addActionListener(this);
        close.addActionListener(this);
        add(toppingList);
        colorBox.addItem("Yellow");
        colorBox.addItem("Blue");
        pizzaBox.addItem("Long");
        pizzaBox.addItem("Short");
        Cart.add(cartList);
        add(colorBox);
        add(pizzaBox);
        add(aLabel);
        add(quantityField);
        add(calc);
        add(clear);
        add(firstlabel);
        add(totalPriceField);
        add(secondlabel);
        add(taxPriceField);
        add(thirdlabel);
        add(endPriceField);
        add(lastlabel);
        add(finalPriceField);
        add(close);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == calc)
        {

            try
            {
                multiplier = Integer.parseInt(quantityField.getText());
            }
            catch(Exception ex)
            {
                multiplier = 0;
            }

            if(!(multiplier == 0))
            {
                int pizzaNum = pizzaBox.getSelectedIndex();
                totalPrice = pizzaPrice[pizzaNum];
                output = "$" + totalPrice;
                output2 = "$" +((double)(totalPrice * .05)) + " ";
                output3 = "$" +((double)(totalPrice + (totalPrice * .05))) + " ";
                a = a + ((double)(multiplier*(totalPrice + (totalPrice * .05)))) ;
                totalPriceField.setText(output);
                taxPriceField.setText(output2);
                endPriceField.setText(output3);
                finalPriceField.setText("$" + Double.toString(a));
                for(int i = 0; i < multiplier; i++)
                    Cart.add(new JLabel(pizzaBox.getSelectedItem().toString() + " " + colorBox.getSelectedItem().toString() + "Skateboard"));
                Cart.invalidate();
                Cart.validate();
                Cart.repaint();

            }
        }
        if(e.getSource() == clear)
        {
            quantityField.setText("");
            totalPriceField.setText("");
            taxPriceField.setText("");
            endPriceField.setText("");
            finalPriceField.setText("");
            a = 0;
            Cart.dispose();
            Cart = new JFrame("My Cart");
            Cart.setSize(200, 400);
            Cart.setLocation(850, 300);
            Cart.setLayout(cartFlow);
            Cart.setVisible(true);
            Cart.setResizable(false);
            Cart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(e.getSource() == close)
        {
            Cart.setVisible(false);
            setVisible(false);
            dispose();
            Cart.dispose();

        }
    }
}