package models

object TraderRepo {
  def getAll: Seq[Trader] = {
    Seq (
      Trader("Raoul", "Cambridge"),
      Trader("Mario", "Milan"),
      Trader("Alan", "Cambridge"),
      Trader("Brian", "Cambridge")
    )
  }
}

object TransactionRepo {
  def getAll : Seq[Transaction] = {
    val traders = TraderRepo.getAll

    Seq(
      Transaction(traders.find(_.name == "Brian").get, 2011, 300),
      Transaction(traders.find(_.name == "Raoul").get, 2012, 1000),
      Transaction(traders.find(_.name == "Raoul").get, 2011, 400),
      Transaction(traders.find(_.name == "Mario").get, 2012, 710),
      Transaction(traders.find(_.name == "Mario").get, 2012, 700),
      Transaction(traders.find(_.name == "Alan").get, 2012, 950)
    )
  }
}