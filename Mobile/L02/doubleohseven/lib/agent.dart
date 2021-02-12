import 'package:flutter/material.dart';

class Agent {
  final String name;
  final String imageName;
  final String activePeriod;
  final int numberOfFilms;
  bool favorite = false;

  Agent({this.name, this.imageName, this.activePeriod, this.numberOfFilms});

  Image getImage() {
    return Image.asset('assets/' + imageName);
  }
}
