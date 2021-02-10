/*
 * Lav et program beregnet til at håndtere spillekort.
 * Repræsentér et spillekort som en instans a klassen Card, så hver instans indeholder 2 properties Color (Clubs, Diamonds, Hearts eller Spades)
 * samt Number (Ace, One, Two, Three, Four, Five, Ten, Jack, Queen eller King).
 * Lav også en collection klasse af spillekort. Udvid klassen med en sort metode, som kan tage en delegate som parameter.
 * Denne delegate skal kunne afgøre om et vilkårligt kort skal sorteres før eller efter et andet vilkårligt kort.
 * Test sort metoden så kortene først sorteres efter Number, dernæst efter Color, idet du sender passende delegate med til hver sortering.
 */

using System;
using System.Collections.Generic;

namespace Øvelse5
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            var cardCollection = new CardCollection();

            cardCollection.AddCard(new Card(Color.Spades, Number.Ace));
            cardCollection.AddCard(new Card(Color.Hearts, Number.King));
            cardCollection.AddCard(new Card(Color.Clubs, Number.Five));
            cardCollection.AddCard(new Card(Color.Clubs, Number.Four));

            cardCollection.PrintCards();

            cardCollection.Sort(CompareNumber);

            cardCollection.PrintCards();

            cardCollection.Sort(CompareColor);

            cardCollection.PrintCards();
        }

        private static int CompareNumber(Card c1, Card c2)
        {
            return c1.Number > c2.Number ? 1 : c1.Number < c2.Number ? -1 : 0;
        }

        private static int CompareColor(Card c1, Card c2)
        {
            return c1.Color > c2.Color ? 1 : c1.Color < c2.Color ? -1 : 0;
        }
    }

    internal class Card
    {
        public Color Color { get; }
        public Number Number { get; }

        public Card(Color color, Number number)
        {
            Color = color;
            Number = number;
        }

        public override string ToString()
        {
            return $"{Number} of {Color}";
        }
    }

    internal class CardCollection
    {
        private readonly List<Card> _cards = new List<Card>();

        public void AddCard(Card card)
        {
            _cards.Add(card);
        }

        public delegate int CardComparator(Card c1, Card c2);

        public void Sort(CardComparator cardComparator)
        {
            _cards.Sort((c1, c2) => cardComparator(c1, c2));
        }

        public void PrintCards()
        {
            Console.WriteLine("[{0}]", string.Join(", ", _cards));
        }
    }

    internal enum Color
    {
        Clubs,
        Diamonds,
        Hearts,
        Spades
    }

    internal enum Number
    {
        Ace,
        One,
        Two,
        Three,
        Four,
        Five,
        Ten,
        Jack,
        Queen,
        King
    }
}