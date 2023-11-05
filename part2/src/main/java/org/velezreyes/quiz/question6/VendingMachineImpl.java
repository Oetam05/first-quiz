package org.velezreyes.quiz.question6;

public class VendingMachineImpl implements VendingMachine {

  private int moneyInserted;

  // Instancia única de la máquina expendedora

  private VendingMachineImpl() {
    // Constructor privado para evitar la creación directa de instancias
  }

  public static VendingMachine getInstance() {

    return new VendingMachineImpl();
  }

  @Override
  public void insertQuarter() {
    moneyInserted += 25; // Asumiendo que un cuarto de dólar se inserta como 25 unidades de dinero.
  }

  @Override
  public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
    switch (name) {
      case "ScottCola":
        if (moneyInserted < 75) {
          throw new NotEnoughMoneyException();
        }
        moneyInserted-=75;
        return new Soda();
      case "KarenTea":
        if (moneyInserted < 100) {
          throw new NotEnoughMoneyException();
        }
        moneyInserted-=100;
        return new Tea();
      default:
        throw new UnknownDrinkException();
    }
  }
}

class Soda implements Drink {
  @Override
  public String getName() {
    return "ScottCola";
  }

  @Override
  public boolean isFizzy() {
    return true;
  }
}

class Tea implements Drink {
  @Override
  public String getName() {
    return "KarenTea";
  }

  @Override
  public boolean isFizzy() {
    return false;
  }
}
