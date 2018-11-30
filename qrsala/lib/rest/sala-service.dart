import 'dart:convert';

import 'package:http/http.dart' as http;

class SalaService {
  final SUCESS = 200;
  String url = "http://10.8.234.30:8081";

  Future<dynamic> obterDistinctNome() async{
    List<dynamic> salas;
    final response = await http.get("$url/qrsala/api/sala/nome/distinct");
     if (response.statusCode == SUCESS) {
      salas = List.from(json.decode(response.body));
    } else {
      throw Exception("Error");
    }
    return salas;
  }


  Future<dynamic> obterDistinctSemana() async{
    List<dynamic> salas;
    final response = await http.get("$url/qrsala/api/sala/semana/distinct");
     if (response.statusCode == SUCESS) {
      salas = List.from(json.decode(response.body));
    } else {
      throw Exception("Error");
    }
    return salas;
  }

  Future<dynamic> obterSalaPorSemana(int nome) async{
    List<dynamic> salas;
    final response = await http.get("$url/qrsala/api/sala/semana/${nome.toString()}");
     if (response.statusCode == SUCESS) {
      salas = List.from(json.decode(response.body));
    } else {
      throw Exception("Error");
    }
    return salas;
  }
}