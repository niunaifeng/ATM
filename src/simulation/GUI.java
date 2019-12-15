 package simulation;import atm.ATM;import banking.Card;import banking.Money;import java.awt.*;import java.awt.event.*;     public class GUI extends Panel{          GUI(SimOperatorPanel operatorPanel,        SimCardReader cardReader,        SimDisplay display,        SimKeyboard keyboard,        SimCashDispenser cashDispenser,        SimEnvelopeAcceptor envelopeAcceptor,        SimReceiptPrinter receiptPrinter,        SimBankPanel bankPanel)    {        setBackground(new Color(242,242,242));                               mainLayout = new CardLayout(5,5);        setLayout(mainLayout);                atmPanel = new ATMPanel(this,                                 operatorPanel, cardReader,                                 display, keyboard,                                cashDispenser, envelopeAcceptor, receiptPrinter, bankPanel);        this.add(atmPanel, "ATM");        billsPanel = new BillsPanel();        add(billsPanel, "BILLS");                cardPanel = new CardPanel();        add(cardPanel, "CARD");        logPanel = new LogPanel(this);        add(logPanel, "LOG");        mainLayout.show(this, "ATM");    }            public Money getInitialCash()    {        mainLayout.show(this, "BILLS");        int numberOfBills = billsPanel.readBills();        mainLayout.show(this, "ATM");                return new Money(20 * numberOfBills);    }            public Card readCard()    {        mainLayout.show(this, "CARD");        int cardNumber = cardPanel.readCardNumber();        mainLayout.show(this, "ATM");                if (cardNumber > 0)            return new Card(cardNumber);        else            return null;    }           public void printLogLine(String text)    {        logPanel.println(text);    }           void showCard(String cardName)    {        mainLayout.show(this, cardName);    }           static GridBagConstraints makeConstraints(                    int row, int col, int width, int height, int fill)    {         GridBagConstraints g = new GridBagConstraints();        g.gridy = row;        g.gridx = col;        g.gridheight = height;        g.gridwidth = width;        g.fill = fill;        g.insets = new Insets(2,2,2,2);        g.weightx = 1;        g.weighty = 1;        g.anchor = GridBagConstraints.CENTER;        return g;    }    public void changeNightMode()    {    	this.setBackground(new Color(20,20,20));    	atmPanel.changeNightMode();   		    }    public void changeDayMode()    {    	this.setBackground(new Color(242,242,242));    	atmPanel.changeDayMode();    }        private CardLayout mainLayout;           private ATMPanel atmPanel;           private BillsPanel billsPanel;           private CardPanel cardPanel;            private LogPanel logPanel;      }    