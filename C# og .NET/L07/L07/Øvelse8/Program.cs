/*
 * (Extra: This is a hard exercise)
 * Learn about the event keyword from this manual : https://docs.microsoft.com/en- us/dotnet/csharp/language-reference/keywords/event (https://docs.microsoft.com/en- us/dotnet/csharp/language-reference/keywords/event)
 * You can also look here:
 * https://www.tutorialsteacher.com/csharp/csharp-event (https://www.tutorialsteacher.com/csharp/csharp-event)
 * Write a class that exposes an event. Show you can notify, register and unregister.
 */

using System;

namespace Øvelse8
{
    internal class Program
    {
        public static void Main(string[] args)
        {

            Publisher publisher = new Publisher();

            Console.WriteLine(" - Registering to event and notify");
            publisher.NotificationsCompleted += publisher_NotificationsCompleted;
            publisher.StartNotification();

            Console.WriteLine(" - Unregistering to event and notify");
            publisher.NotificationsCompleted -= publisher_NotificationsCompleted;
            publisher.StartNotification();

        }

        private static void publisher_NotificationsCompleted()
        {
            Console.WriteLine("Notifications revieved");
        }
    }

    public delegate void Notify();

    public class Publisher
    {
        public event Notify NotificationsCompleted;

        public void StartNotification()
        {
            Console.WriteLine("Notifying..");
            OnNotificationsCompleted();
        }

        protected virtual void OnNotificationsCompleted()
        {
            NotificationsCompleted?.Invoke();
        }
    }
}