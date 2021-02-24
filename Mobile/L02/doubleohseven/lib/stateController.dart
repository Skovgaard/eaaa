import 'package:doubleohseven/agent.dart';

import 'agent.dart';

void addAgent(Agent agent) {
  agents.add(agent);
}

List<Agent> agents = [
  Agent(
      name: 'Daniel Craig',
      imageName: 'daniel_craig.png',
      activePeriod: '2006 - 2020',
      numberOfFilms: 4,
      favorite: false),
  Agent(
      name: 'George Lazenby',
      imageName: 'george_lazenby.png',
      activePeriod: '1969',
      numberOfFilms: 1,
      favorite: false),
  Agent(
      name: 'Pierce Brosnan',
      imageName: 'pierce_brosnan.png',
      activePeriod: '1987 - 1989',
      numberOfFilms: 4,
      favorite: false),
  Agent(
      name: 'Roger Moore',
      imageName: 'roger_moore.png',
      activePeriod: '1973 - 1985',
      numberOfFilms: 7,
      favorite: false),
  Agent(
      name: 'Sean Connery',
      imageName: 'sean_connery.png',
      activePeriod: '1962 – 1967, 1971, 1983',
      numberOfFilms: 7,
      favorite: false),
  Agent(
      name: 'Timothy Dalton',
      imageName: 'timothy_dalton.png',
      activePeriod: '1987 - 1989',
      numberOfFilms: 2,
      favorite: false),
];
