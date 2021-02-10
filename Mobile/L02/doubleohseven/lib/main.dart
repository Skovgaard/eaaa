import 'dart:math';

import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: '007 App',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(),
    );
  }
}

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

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key}) : super(key: key);

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

const bonds = [
  'daniel_craig.png',
  'george_lazenby.png',
  'pierce_brosnan.png',
  'roger_moore.png',
  'sean_connery.png',
  'timothy_dalton.png'
];

class _MyHomePageState extends State<MyHomePage> {
  int _index = 0;

  void changeBond() {
    setState(() => _index = randomNotSameInt(_index));
  }

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: changeBond,
      child: Scaffold(
        appBar: AppBar(
          title: Text('007 agenter'),
          centerTitle: true,
        ),
        // body: Center(child: Image.asset('assets/george_lazenby.png')),
        body: Center(child: Image.asset('assets/' + bonds[_index])),
        floatingActionButton: FloatingActionButton(
          // onPressed: () => setState(() => _index = _random.nextInt(6)),
          onPressed: changeBond,
          tooltip: 'Tilfældig 007',
          child: const Icon(Icons.update),
        ),
      ),
    );
  }
}

int randomNotSameInt(int currentIndex) {
  Random random = new Random();
  int newIndex;
  do {
    newIndex = random.nextInt(bonds.length);
  } while (newIndex == currentIndex);
  return newIndex;
}
