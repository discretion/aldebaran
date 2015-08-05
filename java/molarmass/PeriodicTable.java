public class PeriodicTable {
// Do these declarations need to be in the main method of MolarMass?

  int num;
  String name;
  String symbol; 
  double relativeAtomicMass;
  int group;
  int period;

  public PeriodicTable() {
    name = "Default Name";
    symbol = "Default Symbol";
  }

  public PeriodicTable(int num, double relativeAtomicMass, String name, String symbol, int group, int period) {
  this.num = num;
  this.name = name;
  this.symbol = symbol;
  this.relativeAtomicMass = relativeAtomicMass;
  this.group = group;
  this.period = period;
  }
}