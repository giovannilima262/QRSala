import 'package:flutter/material.dart';
import 'package:qrsala/rest/sala-service.dart';
import 'package:qrsala/salaPage/sala-descricao-windget.dart';

class SalaPage extends StatefulWidget {
  SalaPage(this.semana, {Key key}) : super(key: key);

  final int semana;

  @override
  SalaPageState createState() {
    return new SalaPageState();
  }
}

class SalaPageState extends State<SalaPage> {
  SalaService _salaService = SalaService();
  List<dynamic> salas = List<dynamic>();
  buscarSalaDistinctPorSemana() {
    _salaService.obterSalaDistinctPorSemana(widget.semana).then((data) {
      setState(() {
        salas = data;
      });
    }, onError: () {});
  }

  telaSalaDescricao(nome, semana) {
    Navigator.push(
      context,
      new MaterialPageRoute(
        builder: (BuildContext context) => new SalaDescricaoPage(nome, semana, null),
      ),
    );
  }

  @override
  void initState() {
    super.initState();
    buscarSalaDistinctPorSemana();
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
        ),
      ),
      body: GridView.builder(
        gridDelegate:
            SliverGridDelegateWithFixedCrossAxisCount(crossAxisCount: 2),
        itemCount: salas.length,
        itemBuilder: (context, position) {
          return Card(
            child: ListTile(
              onTap: () => telaSalaDescricao(salas[position], widget.semana),
              title: Center(
                child: Text(
                  salas[position],
                  style: TextStyle(
                    fontSize: 24,
                  ),
                ),
              ),
            ),
          );
        },
      ),
    );
  }
}
