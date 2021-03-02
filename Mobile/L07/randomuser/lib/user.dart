class User {
  final String name;
  final String email;
  final String pictureUrl;

  User({this.name, this.email, this.pictureUrl});

  factory User.fromJson(Map<String, dynamic> data) {
    return User(
        name: data['name']['first'] + ' ' + data['name']['last'],
        email: data['email'],
        pictureUrl: data['picture']['thumbnail']);
  }
}
