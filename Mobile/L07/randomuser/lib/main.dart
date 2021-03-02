import 'package:flutter/material.dart';
import 'package:randomuser/user.dart';
import 'package:randomuser/stateController.dart';
import 'package:cached_network_image/cached_network_image.dart';

void main() {
  runApp(MaterialApp(
      title: 'Random User App',
      theme: ThemeData(primarySwatch: Colors.orange),
      home: HomePage()));
}

class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  Future<List<User>> futureUserList;

  @override
  void initState() {
    super.initState();
    futureUserList = fetchUsers();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Random Users List')),
      body: FutureBuilder(
          future: futureUserList,
          builder: (context, snapshot) {
            if (snapshot.hasData) {
              return ListView.builder(
                itemCount: snapshot.data.length,
                itemBuilder: (context, index) {
                  User user = snapshot.data[index];
                  return Card(
                      child: ListTile(
                          title: Text('${user.name}'),
                          subtitle: Text('${user.email}'),
                          leading: CachedNetworkImage(
                            placeholder: (context, url) =>
                                CircularProgressIndicator(),
                            imageUrl: '${user.pictureUrl}',
                          )));
                },
              );
            }
            return CircularProgressIndicator();
          }),
    );
  }
}
