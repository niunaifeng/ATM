 package simulation;import banking.Money;import java.awt.*;import java.awt.event.*;class SimCashDispenser extends Panel{       SimCashDispenser()    {        setLayout(new GridLayout(1,1));        label = new Label("$XXX.XX", Label.CENTER);        label.setFont(new Font("SansSerif", Font.PLAIN, 24));        label.setForeground(new Color(0, 64, 0));        add(label);        label.setVisible(false);    }           public void animateDispensingCash(Money amount)    {        label.setText(amount.toString());        for (int size = 3; size <= 24; size += 1)        {             label.setFont(new Font("SansSerif", Font.PLAIN, size));            label.setVisible(true);            try            {                 Thread.sleep(250);            }            catch (InterruptedException e)            { }            label.setVisible(false);        }    }           private Label label;}                                       