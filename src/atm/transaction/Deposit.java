 package atm.transaction;import atm.ATM;import atm.Session;import atm.physical.*;import banking.AccountInformation;import banking.Card;import banking.Message;import banking.Money;import banking.Status;import banking.Receipt;public class Deposit extends Transaction{        public Deposit(ATM atm, Session session, Card card, int pin)    {        super(atm, session, card, pin);    }           protected Message getSpecificsFromCustomer() throws CustomerConsole.Cancelled    {        to = atm.getCustomerConsole().readMenuChoice(            "Account to deposit to",            AccountInformation.ACCOUNT_NAMES);        amount = atm.getCustomerConsole().readAmount("Amount to deposit");                return new Message(Message.INITIATE_DEPOSIT,                           card, pin, serialNumber, -1, to, amount);    }           protected Receipt completeTransaction() throws CustomerConsole.Cancelled    {        atm.getEnvelopeAcceptor().acceptEnvelope();        Status status = atm.getNetworkToBank().sendMessage(            new Message(Message.COMPLETE_DEPOSIT,                        card, pin, serialNumber, -1, to, amount),             balances);                    return new Receipt(this.atm, this.card, this, this.balances) {            {                detailsPortion = new String[2];                detailsPortion[0] = "DEPOSIT TO: " +                                     AccountInformation.ACCOUNT_ABBREVIATIONS[to];                detailsPortion[1] = "AMOUNT: " + amount.toString();            }        };    }            private int to;           private Money amount;            }