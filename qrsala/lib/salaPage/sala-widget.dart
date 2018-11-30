import 'package:flutter/material.dart';
import 'package:qrsala/rest/sala-service.dart';

class SalaPage extends StatefulWidget {
  SalaPage(this.nome, {Key key}) : super(key: key);

  final int nome;

  @override
  SalaPageState createState() {
    return new SalaPageState();
  }
}

class SalaPageState extends State<SalaPage> {
  SalaService _salaService = SalaService();
  List<dynamic> salas = List<dynamic>();
  buscarSalaPorNome() {
    _salaService.obterSalaPorSemana(widget.nome).then((data) {
      setState(() {
        salas = data;
      });
    }, onError: () {});
  }

  @override
  void initState() {
    super.initState();
    buscarSalaPorNome();
  }

  @override
  Widget build(BuildContext context) {
    String nome = "";
    return Scaffold(
      appBar: AppBar(
        title: Row(
          children: <Widget>[
            Container(
              margin: EdgeInsets.all(5),
              child: Image.asset("imagens/logo.png"),
            ),
            Text("QRSala"),
          ],
        ),
      ),
      body: ListView.builder(
        itemCount: salas.length,
        itemBuilder: (context, position) {
          if (nome != salas[position]["nome"]) {
            nome = salas[position]["nome"];
            return Padding(
              padding: EdgeInsets.all(5),
              child: Center(
                child: Text(
                salas[position]["nome"],
                style: TextStyle(
                  fontSize: 30,
                ),
              ),
              ),
            );
          }
          return Card(
            child: ListTile(
              title: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                mainAxisAlignment: MainAxisAlignment.center,
                children: <Widget>[
                  Text(
                    salas[position]["nomeProfessor"],
                    style: TextStyle(
                      fontSize: 24,
                    ),
                  ),
                  Text(
                    "Início: ${salas[position]["horarioInicio"]}",
                    style: TextStyle(
                      fontSize: 24,
                    ),
                  ),
                  Text(
                    "Fim: ${salas[position]["horarioFim"]}",
                    style: TextStyle(
                      fontSize: 24,
                    ),
                  ),
                ],
              ),
            ),
          );
        },
      ),
    );
  }
}
