 package simulation;import java.awt.*;import java.awt.event.*;class SimReceiptPrinter extends Panel{       SimReceiptPrinter()    {        setLayout(new BorderLayout(5, 5));                              printArea =             new TextArea("", ATMPanel.PRINTABLE_LINES, ATMPanel.PRINTABLE_CHARS,                         TextArea.SCROLLBARS_VERTICAL_ONLY);        printArea.setBackground(Color.white);        printArea.setForeground(Color.black);        printArea.setFont(new Font("Monospaced", Font.PLAIN, 12));        printArea.setEditable(false);        add(printArea, BorderLayout.SOUTH);                                    Panel buttonPanel = new Panel();        buttonPanel.setLayout(new GridLayout(1,1));        take = new Button("Take receipt");        buttonPanel.add(take);        add(buttonPanel, BorderLayout.NORTH);        take.addActionListener(new ActionListener() {            public void actionPerformed(ActionEvent e)            {                printArea.setText("");                take.setVisible(false);            }        });                take.setVisible(false);    }            void println(String text)    {        printArea.append(text + '\n');        try        {             Thread.sleep(1 * 1000);        }        catch (InterruptedException e)        { }       take.setVisible(true);    }               private TextArea printArea;           private Button take;}                                       