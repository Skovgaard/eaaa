using Øvelse1;
using System;
using System.Collections.Generic;
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

namespace Øvelse3
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        private Person person;

        public MainWindow()
        {
            InitializeComponent();

            person = new Person("Anders And;42;77;100");

            name.DataContext = person;
            age.DataContext = person;
            weight.DataContext = person;
            score.DataContext = person;
            accepted.DataContext = person;

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
    }

    
}