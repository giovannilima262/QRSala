import 'dart:convert';

import 'package:http/http.dart' as http;

class SalaService {
  final SUCESS = 200;
  String url = "http://192.168.25.2:8081";

  Future<dynamic> buscarSalaPorNomeAndSemana(nome, semana) async {
    List<dynamic> salas;
    final response =
        await http.get("$url/qrsala/api/sala/nome/$nome/semana/$semana");
    if (response.statusCode == SUCESS) {
      salas = List.from(json.decode(response.body));
    } else {
      throw Exception("Error");
    }
    return salas;
  }

  Future<dynamic> buscarPorQrCode(urlQrCode) async {
    List<dynamic> salas;
    final response = await http.get(urlQrCode);
    if (response.statusCode == SUCESS) {
      salas = List.from(json.decode(response.body));
    } else {
      throw Exception("Error");
    }
    return salas;
  }

  Future<dynamic> obterDistinctSemana() async {
    List<dynamic> salas;
    final response = await http.get("$url/qrsala/api/sala/semana/distinct");
    if (response.statusCode == SUCESS) {
      salas = List.from(json.decode(response.body));
    } else {
      throw Exception("Error");
    }
    return salas;
  }

  Future<dynamic> obterSalaDistinctPorSemana(int nome) async {
    List<dynamic> salas;
    final response = await http
        .get("$url/qrsala/api/sala/distinct/semana/${nome.toString()}");
    if (response.statusCode == SUCESS) {
      salas = List.from(json.decode(response.body));
    } else {
      throw Exception("Error");
    }
    return salas;
  }
}
