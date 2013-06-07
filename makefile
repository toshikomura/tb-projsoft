all:
	javac -J-Xmx2G Livraria.java
exec:
	java -Xmx2G Programa
del:
	rm -rf *.class
clean:
	rm -rf *.class
