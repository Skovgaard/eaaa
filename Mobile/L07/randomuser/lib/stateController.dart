import 'package:randomuser/user.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

Future<List<User>> fetchUsers() async {
  String url = 'https://randomuser.me/api/?results=100';
  final response = await http.get(url);
  List<User> users = [];
  if (response.statusCode == 200) {
    var jsonData = jsonDecode(response.body);
    List<dynamic> jsonUsers = jsonData['results'];
    jsonUsers.forEach((e) => users.add(User.fromJson(e)));
    return users;
  } else {
    throw new Exception('Could not fetch random users');
  }
}
