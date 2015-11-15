package kata.tennis

sealed trait Player

sealed trait Score {
  def up() : Score
}

case class TennisGame(gameScore: GameScore) {

  def play(winner: Player): TennisGame = {
    val game = (gameScore.service, gameScore.receiver, winner) match {
      case (Forty, Forty, Player1) => TennisGame(GameScore(Advantage, Forty))
      case (Forty, Forty, Player2) => TennisGame(GameScore(Forty, Advantage))
      case (_, Advantage, Player1) => TennisGame(GameScore(Forty, Forty))
      case (Advantage, _, Player2) => TennisGame(GameScore(Forty, Forty))
      case (_, _, Player1) => TennisGame(gameScore.winService())
      case (_, _, Player2) => TennisGame(gameScore.winReceiver())
    }

    game
  }
}

case class GameScore(service : Score, receiver : Score) {
  def winService() : GameScore = {
    GameScore(service.up(), receiver)
  }

  def winReceiver() : GameScore = {
    GameScore(service, receiver.up())
  }
}


case object Love extends Score {
  val up : Score = { Fifteen }
}

case object Fifteen extends Score {
  val up : Score = { Thirty }
}

case object Thirty extends Score {
  val up : Score = { Forty }
}

case object Forty extends Score {
  val up : Score = { Win }
}

case object Advantage extends Score {
  val up : Score = { Win }
}

case object Win extends Score {
  val up : Score = { Win }
}

case object Player1 extends Player

case object Player2 extends Player
