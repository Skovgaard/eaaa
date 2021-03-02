import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:pokemon/pokemon.dart';
import 'package:http/http.dart' as http;

void main() {
  runApp(MaterialApp(
      title: 'Pokémon',
      theme: ThemeData(primarySwatch: Colors.red),
      home: HomePage()));
}

class HomePage extends StatefulWidget {
  HomePage({Key key}) : super(key: key);

  @override
  _HomePageState createState() => _HomePageState();
}

Future<List<Pokemon>> fetchPokemons() async {
  final response =
      await http.get('https://pokeapi.co/api/v2/pokemon/?limit=151');
  List<Pokemon> pokemons = [];
  if (response.statusCode == 200) {
    var jsonData = jsonDecode(response.body);
    List<dynamic> jsonPokemons = jsonData['results'];
    jsonPokemons.forEach((e) => pokemons.add(Pokemon.fromJson(e)));
    return pokemons;
  } else {
    throw new Exception('Could not fetch pokemons');
  }
}

class _HomePageState extends State<HomePage> {
  Future<List<Pokemon>> futurePokemonList;

  @override
  void initState() {
    super.initState();
    futurePokemonList = fetchPokemons();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Pokemons')),
      body: FutureBuilder(
        future: futurePokemonList,
        builder: (context, snapshot) {
          if (snapshot.hasData) {
            // TODO
            return ListView.builder(
              itemCount: snapshot.data.length,
              itemBuilder: (context, index) {
                Pokemon pokemon = snapshot.data[index];
                return Card(
                    child: ListTile(
                  title: Text('${pokemon.name}'),
                  subtitle: Text('${pokemon.url}'),
                  leading: FutureBuilder(
                    future: pokemon.fetchImageURL(),
                    builder: (context, snapshot) {
                      if (snapshot.hasData) return Image.network(snapshot.data);
                      return CircularProgressIndicator();
                      // return Text(index.data);
                    },
                  ),
                ));
              },
            );
          }
          return CircularProgressIndicator();
        },
      ),
    );
  }
}
