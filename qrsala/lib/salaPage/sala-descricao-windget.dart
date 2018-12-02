import 'package:flutter/material.dart';
import 'package:qrsala/rest/sala-service.dart';

class SalaDescricaoPage extends StatefulWidget {
  SalaDescricaoPage(this.nome, this.semana, this.qrCode, {Key key})
      : super(key: key);

  final String nome;

  final int semana;

  final String qrCode;

  @override
  SalaDescricaoPageState createState() {
    return new SalaDescricaoPageState();
  }
}

class SalaDescricaoPageState extends State<SalaDescricaoPage> {
  SalaService _salaService = SalaService();
  List<dynamic> salas = List<dynamic>();
  buscarSalaPorNomeAndSemana() {
    _salaService.buscarSalaPorNomeAndSemana(widget.nome, widget.semana).then(
        (data) {
      setState(() {
        salas = data;
      });
    }, onError: () {});
  }

  @override
  void initState() {
    super.initState();
    if (widget.qrCode == null) {
      buscarSalaPorNomeAndSemana();
    } else {
      _salaService.buscarPorQrCode(widget.qrCode).then((data) {
        setState(() {
          salas = data;
        });
      }, onError: () {});
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Row(
          children: <Widget>[
            Text(salas != null && salas.isNotEmpty ? salas[0]["nome"] : ""),
          ],
        ),
      ),
      body: ListView.builder(
        itemCount: salas.length,
        itemBuilder: (context, position) {
          return Padding(
            padding: EdgeInsets.fromLTRB(10, 0, 10, 10),
            child: Card(
              child: Column(
                children: <Widget>[
                  Padding(
                    padding: EdgeInsets.all(10),
                    child: ListTile(
                      title: Center(
                        child: Text(
                          salas[position]["nomeProfessor"],
                          style: TextStyle(
                            fontSize: 24,
                          ),
                        ),
                      ),
                    ),
                  ),
                  Container(
                    alignment: Alignment.centerLeft,
                    padding: EdgeInsets.all(10),
                    child: Text(
                      "Horário Início: ${salas[position]["horarioInicio"]}",
                      style: TextStyle(fontSize: 20),
                    ),
                  ),
                  Container(
                    alignment: Alignment.centerLeft,
                    padding: EdgeInsets.all(10),
                    child: Text(
                      "Horário Fim: ${salas[position]["horarioFim"]}",
                      style: TextStyle(fontSize: 20),
                    ),
                  ),
                  Padding(
                    padding: EdgeInsets.all(10),
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
