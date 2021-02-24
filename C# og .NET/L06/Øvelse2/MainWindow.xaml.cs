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
        }

        private void Button1_Click(object sender, RoutedEventArgs e)
        {
            string temp = l1.Content.ToString();
            l1.Content = l3.Content;
            l3.Content = temp;
        }

        private void Button2_Click(object sender, RoutedEventArgs e)
        {
            string temp = l2.Content.ToString();
            l2.Content = l4.Content;
            l4.Content = temp;
        }
    }
}
