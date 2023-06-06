rm -r build
mkdir build
find -name "*.java" > build/sourcelist.txt
javac @build/sourcelist.txt -d build
cd build
java Program "$@"
