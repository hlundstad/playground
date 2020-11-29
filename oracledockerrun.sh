
docker run --name oracle19 \
-p 1521:1521 -p 5500:5500 \
-e ORACLE_SID=ORCLCDB \
-e ORACLE_PDB=ORCLPDB1 \
-e ORACLE_PWD=oracle123 \
-v /Users/hegelundstad/Projects/myprojects1/playground/providers/src/main/resources/db/oracle/sql:/docker-entrypoint-initdb.d/setup \
-d oracle/database:19.3.0-se2
#-e INIT_SGA_SIZE=<your database SGA memory in MB> \
#-e INIT_PGA_SIZE=<your database PGA memory in MB> \
#-e ORACLE_CHARACTERSET=<your character set> \

#DIRECTORY=`dirname $0`
#DIRECTORY=$(realpath $DIRECTORY)

#docker run --name oracle \
# -p 1521:1521 -p 5500:5500 \
# --shm-size=1g \
#-v sql:/docker-entrypoint-initdb.d/setup/ \
# -d oracle/database:19.3.0-se2
#-v ${DIRECTORY}/sql/:/docker-entrypoint-initdb.d/setup/ \
