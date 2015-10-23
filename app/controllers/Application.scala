package controllers

import play.api._
import play.api.mvc._
import scala.math.Ordered.orderingToOrdered

import models.{Trader, Transaction, TraderRepo, TransactionRepo}

class Application extends Controller {

  def index = Action {
    val transactions = TransactionRepo.getAll
    val traders = TraderRepo.getAll

    val res : Map[String, String] = Map(
      "Transactions de 2011 par valeur croissante " -> transactions.filter(_.year == 2011).sortBy(_.value).toString,
      "Villes où au moins un trader travaille" -> traders.map(_.city).toSet.toString,
      "Trouver les traders de Cambridge et les trier par nom" -> traders.filter(_.city == "Cambridge").sortBy(_.name).map(_.name).mkString(", "),
      "Retourner une String contenant les noms des traders dans l’ordre alphabétique" -> traders.map(_.name).sorted.mkString(", "),
      "Y-a-t’il au moins un trader à Milan ?" -> traders.filter(_.city == "Milan").nonEmpty.toString,
      "Afficher les valeurs des transactions des traders de Cambridge" -> transactions.filter(_.trader.city == "Cambridge").map(_.value).mkString(", "),
      "Quelle est la valeur de transaction la plus élevée ?" -> transactions.maxBy(_.value).value.toString,
      "Trouver la transaction avec la valeur la plus faible" -> transactions.minBy(_.value).value.toString
    )
    Ok(views.html.index(res))
  }
}