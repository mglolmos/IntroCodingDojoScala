package kata.tennis

import org.scalatest.{ShouldMatchers, FlatSpec}


class TennisGameSpec extends FlatSpec with ShouldMatchers {

  behavior of "Tennis Game"

  it should "if 0-0 and win player1 return 15-0" in {
    TennisGame(GameScore(Love, Love)).play(Player1) should equal(TennisGame(GameScore(Fifteen, Love)))
  }

  it should "if 0-0 and win player2 return 0-15" in {
    TennisGame(GameScore(Love, Love)).play(Player2) should equal(TennisGame(GameScore(Love, Fifteen)))
  }

  it should "if 15-0 and win player1 return 30-0" in {
    TennisGame(GameScore(Fifteen, Love)).play(Player1) should equal(TennisGame(GameScore(Thirty, Love)))
  }

  it should "if 0-15 and win player2 return 0-30" in {
    TennisGame(GameScore(Love, Fifteen)).play(Player2) should equal(TennisGame(GameScore(Love, Thirty)))
  }

  it should "if 30-0 and win player1 return 40-0" in {
    TennisGame(GameScore(Thirty, Love)).play(Player1) should equal(TennisGame(GameScore(Forty, Love)))
  }

  it should "if 0-30 and win player2 return 0-40" in {
    TennisGame(GameScore(Love, Thirty)).play(Player2) should equal(TennisGame(GameScore(Love, Forty)))
  }

  it should "if 40-30 and win player1 return Win-30" in {
    TennisGame(GameScore(Forty, Thirty)).play(Player1) should equal(TennisGame(GameScore(Win, Thirty)))
  }

  it should "if 30-40 and win player2 return 30-Win" in {
    TennisGame(GameScore(Thirty, Forty)).play(Player2) should equal(TennisGame(GameScore(Thirty, Win)))
  }

  it should "if 40-40 and win player1 return Advantage-40" in {
    TennisGame(GameScore(Forty, Forty)).play(Player1) should equal(TennisGame(GameScore(Advantage, Forty)))
  }

  it should "if 40-40 and win player2 return 40-Advantage" in {
    TennisGame(GameScore(Forty, Forty)).play(Player2) should equal(TennisGame(GameScore(Forty, Advantage)))
  }

  it should "if 40-Advantage and win player1 return 40-40" in {
    TennisGame(GameScore(Forty, Advantage)).play(Player1) should equal(TennisGame(GameScore(Forty, Forty)))
  }

  it should "if Advantage-40 and win player2 return 40-40" in {
    TennisGame(GameScore(Advantage, Forty)).play(Player2) should equal(TennisGame(GameScore(Forty, Forty)))
  }

  it should "if Advantage-40 and win player1 return Win-40" in {
    TennisGame(GameScore(Advantage, Forty)).play(Player1) should equal(TennisGame(GameScore(Win, Forty)))
  }

  it should "if 40-Advantage and win player2 return 40-Win" in {
    TennisGame(GameScore(Forty, Advantage)).play(Player2) should equal(TennisGame(GameScore(Forty, Win)))
  }
}
