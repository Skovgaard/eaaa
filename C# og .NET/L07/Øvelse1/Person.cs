using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Øvelse1
{
    public class Person : INotifyPropertyChanged
    {
        private string name;
        private int score;

        public String Name { get { return name; } set { name = value; NotifyPropertyChanged("Name"); } }
        public int Age { get; set; }
        public int Weight { get; set; }
        public int Score { get { return score; } set { score = value; NotifyPropertyChanged("Score"); } }
        public bool Accepted { get; set; }

        public Person(string s)
        {
            string[] split = s.Split(';');
            Name = split[0];
            Age = int.Parse(split[1]);
            Weight = int.Parse(split[2]);
            Score = int.Parse(split[3]);
        }

        public event PropertyChangedEventHandler PropertyChanged;

        private void NotifyPropertyChanged(string propertyName)
        {
            if (PropertyChanged != null)
            {
                PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
            }
        }

        public override string ToString()
        {
            return String.Format("{0} : {1} years, {2} kg, {3} score, isAccepted {4}", Name, Age, Weight, Score, Accepted);
        }
    }
}
