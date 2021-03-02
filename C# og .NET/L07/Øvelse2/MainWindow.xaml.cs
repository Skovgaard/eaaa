using System;
using System.Collections.Generic;
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

using Øvelse1;

namespace Øvelse2
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            Person person = new Person("Anders And;42;77;100");

            PersonNameLabel = person.Name;
            PersonAgeLabel = person.Age.ToString();
            PersonWeightLabel = person.Weight.ToString();
            PersonScoreLabel = person.Score.ToString();
            PersonAcceptedLabel = person.Accepted.ToString();

            name.DataContext = this;
            age.DataContext = this;
            weight.DataContext = this;
            score.DataContext = this;
            accepted.DataContext = this;

        }

    public string PersonNameLabel { set; get; }
        public string PersonAgeLabel { set; get; }
        public string PersonWeightLabel { set; get; }
        public string PersonScoreLabel { set; get; }
        public string PersonAcceptedLabel { set; get; }
    }
}