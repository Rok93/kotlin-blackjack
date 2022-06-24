package blackjack.domain

import blackjack.domain.card.Card
import blackjack.domain.card.Cards
import blackjack.domain.card.Face
import blackjack.domain.card.Suit
import blackjack.domain.player.Player
import blackjack.domain.player.Players
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class BlackjackGameTest : StringSpec({
    "블랙잭 게임이 진행중인 상태인지 파악한다." {
        listOf(
            row(
                mutableListOf(
                    Card(Suit.CLOVER, Face.ACE),
                    Card(Suit.CLOVER, Face.TEN),
                ),
                false
            ),
            row(
                mutableListOf(
                    Card(Suit.CLOVER, Face.NINE),
                    Card(Suit.CLOVER, Face.TEN),
                ),
                true
            ),
        ).forEach { (cards, expected) ->
            // given
            val blackjackGame = BlackjackGame(
                deck = Deck.createOf(),
                players = Players(
                    listOf(
                        Player(
                            "김경록",
                            Cards(cards),
                        )
                    )
                ),
            )

            // when
            val actual = blackjackGame.isPlaying()

            // then
            actual shouldBe expected
        }
    }
})