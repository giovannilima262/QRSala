import 'dart:convert';

import 'package:http/http.dart' as http;

class SalaService {
  final SUCESS = 200;

  Future<dynamic> obterDistinctNome() async{
    List<dynamic> salas;
    final response = await http.get("http://192.168.25.2:8081/qrsala/api/sala/distinct");
     if (response.statusCode == SUCESS) {
      salas = List.from(json.decode(response.body));
    } else {
      throw Exception("Error");
    }
    return salas;
  }

  Future<dynamic> obterSalaPorNome(String nome) async{
    List<dynamic> salas;
    final response = await http.get("http://192.168.25.2:8081/qrsala/api/sala/$nome");
     if (response.statusCode == SUCESS) {
      salas = List.from(json.decode(response.body));
    } else {
      throw Exception("Error");
    }
    return salas;
  }
}