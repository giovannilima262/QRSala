import 'package:flutter/material.dart';
import 'package:qrsala/rest/sala-service.dart';

class SalaPage extends StatefulWidget {
  SalaPage(this.nome, {Key key}) : super(key: key);

  final String nome;

  @override
  SalaPageState createState() {
    return new SalaPageState();
  }
}

class SalaPageState extends State<SalaPage> {
  SalaService _salaService = SalaService();
  List<dynamic> salas = List<dynamic>();
  buscarSalaPorNome() {
    _salaService.obterSalaPorNome(widget.nome).then((data) {
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
      )),
      body: ListView.builder(
          itemCount: salas.length,
          itemBuilder: (context, position) {
            return Card(
              child: Text(salas[position]["descricaoDiaSemana"]),
            );
          }),
    );
  }
}
