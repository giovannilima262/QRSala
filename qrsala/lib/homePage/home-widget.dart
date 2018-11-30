import 'package:flutter/material.dart';
import 'package:qrsala/homePage/home-controller.dart';
import 'package:bloc_pattern/bloc_pattern.dart';

class HomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    HomeController homeController = BlocProvider.of<HomeController>(context);
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
      body: Padding(
          padding: EdgeInsets.all(5),
          child: StreamBuilder(
            stream: homeController.outSalas,
            initialData: List<dynamic>(),
            builder: (BuildContext context, AsyncSnapshot snapshot) {
              return GridView.builder(
                gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
                    crossAxisCount: 2),
                itemCount: snapshot.data.length,
                itemBuilder: (context, position) {
                  return Card(
                    child: ListTile(
                      onTap: () =>
                          homeController.telaSala(snapshot.data[position]["diaSemana"]),
                      title: Center(
                        child: Text(
                          snapshot.data[position]["descricaoSemana"],
                          style: TextStyle(
                            fontSize: 24,
                          ),
                        ),
                      ),
                    ),
                  );
                },
              );
            },
          )),
      floatingActionButton: FloatingActionButton.extended(
        icon: Icon(Icons.camera_alt),
        label: Text("Scan"),
        onPressed: homeController.scanQR,
      ),
      floatingActionButtonLocation: FloatingActionButtonLocation.centerFloat,
    );
  }
}
