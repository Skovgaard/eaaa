import 'dart:math';
import 'package:flutter/material.dart';
import 'stateController.dart';
import 'agent.dart';
import 'package:date_time_picker/date_time_picker.dart';

void main() {
  runApp(MyApp());
}

// Iteration 3

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(initialRoute: '/', routes: {
      '/': (context) => HomePage(),
      '/details': (context) => DetailsPage(),
      '/add': (context) => AddNewBondPage()
    });
  }
}

class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('007 agents'),
      ),
      body: ListView.separated(
        padding: const EdgeInsets.all(8),
        itemCount: agents.length,
        itemBuilder: (context, index) {
          final agent = agents[index];

          return GestureDetector(
            onTap: () => _NavigateToDetails(agent),
            child: ListTile(
              title: Text(agent.name),
              subtitle: Text(agent.activePeriod),
              leading: agent.getImage(),
              trailing: Icon(agent.favorite ? Icons.star : Icons.star_border),
            ),
          );
        },
        separatorBuilder: (BuildContext context, int index) => const Divider(),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () => _NavigateToNewBond(),
        tooltip: 'Tilføj ny',
        child: const Icon(Icons.add),
      ),
    );
  }

  void _NavigateToDetails(Agent agent) async {
    await Navigator.pushNamed(context, '/details',
        arguments: DetailsPageArguments(agent));
    setState(() {}); // Update state on return
  }

  void _NavigateToNewBond() async {
    var result = await Navigator.pushNamed(context, '/add');
    if (result != null) {
      agents.add(result);
      setState(() {}); // Update
    }
  }
}

class DetailsPageArguments {
  Agent agent;

  DetailsPageArguments(this.agent);
}

class DetailsPage extends StatefulWidget {
  @override
  _DetailsPageState createState() => _DetailsPageState();
}

class _DetailsPageState extends State<DetailsPage> {
  @override
  Widget build(BuildContext context) {
    final DetailsPageArguments args = ModalRoute.of(context).settings.arguments;
    final agent = args.agent;

    return Scaffold(
      appBar: AppBar(
        title: Text(agent.name),
        actions: [
          IconButton(
            // icon: const Icon(Icons.star_border),
            icon: Icon(agent.favorite ? Icons.star : Icons.star_border),
            tooltip: 'Favorite',
            onPressed: () {
              setState(() {
                agent.favorite = !agent.favorite;
              });
            },
          )
        ],
      ),
      body: ListView(
        padding: const EdgeInsets.all(8),
        children: [
          Container(
            height: 700,
            child: agent.getImage(),
          ),
          Container(
            child: Text(
              'Active period: ' + agent.activePeriod,
              style: TextStyle(fontSize: 20),
              textAlign: TextAlign.center,
            ),
          ),
          Container(
              child: Text(
            'Number of films: ' + agent.numberOfFilms.toString(),
            style: TextStyle(fontSize: 20),
            textAlign: TextAlign.center,
          ))
        ],
      ),
    );
  }
}

class AddNewBondPage extends StatefulWidget {
  @override
  _AddNewBondPageState createState() => _AddNewBondPageState();
}

class _AddNewBondPageState extends State<AddNewBondPage> {
  final _formKey = GlobalKey<FormState>();

  String _name = "";
  bool _favorite = false;
  String _startDate;
  String _endDate;
  int _numberOfFilms = 0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Adding new bond'),
        actions: <Widget>[
          new IconButton(
            icon: const Icon(Icons.save),
            onPressed: () {
              final form = _formKey.currentState;
              if (form.validate()) {
                form.save();

                Navigator.pop(
                  context,
                  new Agent(
                      name: _name,
                      imageName: 'daniel_craig.png',
                      activePeriod: _startDate.split('-')[0] +
                          '-' +
                          _endDate.split('-')[0],
                      numberOfFilms: _numberOfFilms,
                      favorite: _favorite),
                );
              }
            },
          )
        ],
      ),
      body: Form(
          key: _formKey,
          child: Padding(
            padding: const EdgeInsets.all(8.0),
            child: Column(
              children: <Widget>[
                TextFormField(
                  decoration: InputDecoration(labelText: 'Name'),
                  onSaved: (val) => setState(() => _name = val),
                  validator: (value) {
                    if (value.isEmpty) {
                      return 'Please enter some text';
                    }
                    return null;
                  },
                ),
                SwitchListTile(
                  title: const Text('Favorite'),
                  value: _favorite,
                  onChanged: (bool val) => setState(() => _favorite = val),
                ),
                DateTimePicker(
                  type: DateTimePickerType.date,
                  initialValue: '',
                  firstDate: DateTime(1950),
                  lastDate: DateTime(2100),
                  icon: Icon(Icons.event),
                  dateLabelText: 'Start of active period',
                  onChanged: (val) => setState(() => _startDate = val),
                  validator: (val) {
                    if (val.isEmpty) {
                      return 'Please enter some text';
                    }
                    return null;
                  },
                  onSaved: (val) => setState(() => _startDate = val),
                ),
                DateTimePicker(
                  type: DateTimePickerType.date,
                  initialValue: '',
                  firstDate: DateTime(1950),
                  lastDate: DateTime(2100),
                  icon: Icon(Icons.event),
                  dateLabelText: 'End of active period',
                  onChanged: (val) => setState(() => _endDate = val),
                  validator: (val) {
                    if (val.isEmpty) {
                      return 'Please enter some text';
                    }
                    return null;
                  },
                  onSaved: (val) => setState(() => _endDate = val),
                ),
                TextFormField(
                  decoration: InputDecoration(labelText: 'Number of films'),
                  onSaved: (val) =>
                      setState(() => _numberOfFilms = int.parse(val)),
                  validator: (value) {
                    if (value.isEmpty) {
                      return 'Please enter some number';
                    }
                    return null;
                  },
                ),
              ],
            ),
          )),
    );
  }
}

// ---------

// Brugt i første og anden
// class MyApp extends StatelessWidget {
//   // This widget is the root of your application.
//   @override
//   Widget build(BuildContext context) {
//     return MaterialApp(
//       title: '007 App',
//       theme: ThemeData(
//         primarySwatch: Colors.blue,
//       ),
//       home: MyHomePage(),
//     );
//   }
// }

// Første iteration

// class MyHomePage extends StatelessWidget {
//   const MyHomePage({Key key}) : super(key: key);

//   @override
//   Widget build(BuildContext context) {
//     return Scaffold(
//         body: Center(
//       child: Image.asset('assets/george_lazenby.png'),
//     ));

//     // return Container(
//     //   color: Colors.blue,
//     //   child: Image.asset('assets/george_lazenby.png'),
//     // );
//     // return Image.asset('assets/george_lazenby.png');
//   }
// }

// ----------

// Anden iteration

// class MyHomePage extends StatefulWidget {
//   MyHomePage({Key key}) : super(key: key);

//   @override
//   _MyHomePageState createState() => _MyHomePageState();
// }

// const bonds = [
//   'daniel_craig.png',
//   'george_lazenby.png',
//   'pierce_brosnan.png',
//   'roger_moore.png',
//   'sean_connery.png',
//   'timothy_dalton.png'
// ];

// class _MyHomePageState extends State<MyHomePage> {
//   int _index = 0;

//   void changeBond() {
//     setState(() => _index = randomNotSameInt(_index));
//   }

//   @override
//   Widget build(BuildContext context) {
//     return GestureDetector(
//       onTap: changeBond,
//       child: Scaffold(
//         appBar: AppBar(
//           title: Text('007 agenter'),
//           centerTitle: true,
//         ),
//         // body: Center(child: Image.asset('assets/george_lazenby.png')),
//         body: Center(child: Image.asset('assets/' + bonds[_index])),
//         floatingActionButton: FloatingActionButton(
//           // onPressed: () => setState(() => _index = _random.nextInt(6)),
//           onPressed: changeBond,
//           tooltip: 'Tilfældig 007',
//           child: const Icon(Icons.update),
//         ),
//       ),
//     );
//   }
// }

// int randomNotSameInt(int currentIndex) {
//   Random random = new Random();
//   int newIndex;
//   do {
//     newIndex = random.nextInt(bonds.length);
//   } while (newIndex == currentIndex);
//   return newIndex;
// }

// ----------
