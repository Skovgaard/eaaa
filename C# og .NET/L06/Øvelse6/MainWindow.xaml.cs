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

namespace Øvelse6
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void Checked(object sender, RoutedEventArgs e)
        {
            statusbarText1.Text = "Radio button " + (sender as RadioButton).Name + " is checked";
        }

        private void CheckedCB(object sender, RoutedEventArgs e)
        {
            int counter = 0;
            if ((bool) cb1.IsChecked) counter++;
            if ((bool) cb2.IsChecked) counter++;
            if ((bool) cb3.IsChecked) counter++;
            if ((bool) cb4.IsChecked) counter++;
            statusbarText2.Text = counter + " checked boxes";
        }
    }
}
