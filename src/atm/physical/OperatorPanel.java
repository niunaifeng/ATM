 package atm.physical;import atm.ATM;import banking.Money;import simulation.Simulation; public class OperatorPanel{        public OperatorPanel(ATM atm)    {        this.atm = atm;    }                public Money getInitialCash()    {        return Simulation.getInstance().getInitialCash();    }            private ATM atm;    }