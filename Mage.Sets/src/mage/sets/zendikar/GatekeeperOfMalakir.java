/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.sets.zendikar;

import java.util.UUID;
import mage.Constants.CardType;
import mage.Constants.Duration;
import mage.Constants.Rarity;
import mage.MageInt;
import mage.abilities.common.EntersBattlefieldTriggeredAbility;
import mage.abilities.condition.common.KickedCondition;
import mage.abilities.costs.mana.KickerManaCost;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.decorator.ConditionalTriggeredAbility;
import mage.abilities.effects.common.continious.GainAbilitySourceEffect;
import mage.abilities.effects.common.SacrificeEffect;
import mage.abilities.keyword.KickerAbility;
import mage.cards.CardImpl;
import mage.filter.common.FilterControlledPermanent;
import mage.target.TargetPlayer;

/**
 *
 * @author maurer.it_at_gmail.com
 */
public class GatekeeperOfMalakir extends CardImpl<GatekeeperOfMalakir> {

	private static final FilterControlledPermanent filter;

	static {
		filter = new FilterControlledPermanent();
		filter.getCardType().add(CardType.CREATURE);
		filter.setMessage(" a creature");
	}

	public GatekeeperOfMalakir(UUID ownerId) {
		super(ownerId, 89, "Gatekeeper of Malakir", Rarity.UNCOMMON, new CardType[]{CardType.CREATURE}, "{B}{B}");
		this.expansionSetCode = "ZEN";
		this.subtype.add("Vampire");
		this.subtype.add("Warrior");

		this.color.setBlack(true);
		this.power = new MageInt(2);
		this.toughness = new MageInt(2);

        this.getSpellAbility().addOptionalCost(new KickerManaCost("{B}"));

		EntersBattlefieldTriggeredAbility ability =
				new EntersBattlefieldTriggeredAbility(new SacrificeEffect(filter, 1, "target player"));
		ability.addTarget(new TargetPlayer());

		this.addAbility(new ConditionalTriggeredAbility(ability, KickedCondition.getInstance(), "When {this} enters the battlefield, if it was kicked, target player sacrifices a creature"));
	}

	public GatekeeperOfMalakir(final GatekeeperOfMalakir card) {
		super(card);
	}

	@Override
	public GatekeeperOfMalakir copy() {
		return new GatekeeperOfMalakir(this);
	}
}
