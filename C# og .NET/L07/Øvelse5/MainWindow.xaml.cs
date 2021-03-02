using Øvelse1;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Øvelse5
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        private Person person;

        private ObservableCollection<Person> persons = new ObservableCollection<Person>();

        public MainWindow()
        {
            InitializeComponent();

            persons.Add(new Person("Anders And;42;77;100"));
            persons.Add(new Person("Onkel Joakim;60;55;200"));
            persons.Add(new Person("Fedtmule;35;90;50"));

            lvPersons.ItemsSource = persons;
        }

        private void TextBox_NameChanged(object sender, TextChangedEventArgs e)
        {
            if (person != null)
            {
                person.Name = ((TextBox)sender).Text;
            }
        }

        private void TextBox_ScoreChanged(object sender, TextChangedEventArgs e)
        {
            if (person != null)
            {
                person.Score = int.Parse(((TextBox)sender).Text);
            }
        }

        private void ListView_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            person = (Person)e.AddedItems[0];

            Binding myBinding = new Binding("Age");
            myBinding.Source = person;
            age.SetBinding(Label.ContentProperty, myBinding);

            name.DataContext = person;
            age.DataContext = person;
            weight.DataContext = person;
            score.DataContext = person;
            accepted.DataContext = person;
        }
    }

    
}