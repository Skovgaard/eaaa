using System;
using System.Collections.Generic;

/*
 * Implement a generic collection class that contains objects of a specified type. 
 * The collection class should have the following methods:
 * 
 * bool AddElement(Key k, Element k)
 * Inserts an element k into the collection. The function must fail if the key is already occupied by some other element.
 * 
 * Element GetElement(Key k)
 * Retrieves an element identified by the Key k. If not found then the function returns null.
 * 
 * Int Size()
 * Returns the number of elements in the collection.
 * 
 * Use the class Dictionary to implement a private class member that stores the element.
 */

namespace Øvelse11
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            var genericCollection = new GenericCollection<string, object>();
            genericCollection.AddElement("1", 1);
            genericCollection.AddElement("2", 2);
            genericCollection.AddElement("3", "tre");
            Console.WriteLine(genericCollection.GetElement("1"));
            Console.WriteLine(genericCollection.GetElement("2"));
            Console.WriteLine(genericCollection.GetElement("3"));
            Console.WriteLine(genericCollection.Size());

            Console.WriteLine();

        }
    }

    class GenericCollection<TKey, TElement>
    {
        private readonly Dictionary<TKey, TElement> _dictionary = new Dictionary<TKey, TElement>();

        //Inserts an element k into the collection. The function must fail if the key is already occupied by some other element.
        public bool AddElement(TKey k, TElement e)
        {
            if (!_dictionary.ContainsKey(k))
            {
                _dictionary.Add(k, e);
                return true;
            }
            else
                return false;
        }

        // Retrieves an element identified by the Key k. If not found then the function returns null.
        public TElement GetElement(TKey k)
        {
            return _dictionary[k];
        }

        // Returns the number of elements in the collection.
        public int Size()
        {
            return _dictionary.Count;
        }
    }
}
