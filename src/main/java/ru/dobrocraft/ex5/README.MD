## Задание 5: Реализация Core-функционала Системы Процессов T-Saurus

### Описание задачи

В этом задании необходимо реализовать core-функционал системы исполнения процессов "T-Saurus". Задача заключается не в минимизации времени выполнения процессов, а в перечислении порядка их исполнения, который достигает это время.

Для этого нужно разбить все процессы на непересекающиеся множества процессов, пронумерованных от 1 до k, так чтобы можно было выполнять все процессы из первого множества, затем второго множества и так далее. Это должно удовлетворять следующему условию: в i-ом множестве должны присутствовать только те процессы, для которых все необходимые для их выполнения процессы находятся в множествах с меньшими номерами.

Функционал системы "T-Saurus" предполагает последовательное исполнение предыдущих множеств, чтобы процессы в очередном множестве смогли выполниться.

### Формат входных данных

1. В первой строке дано число n (1 ≤ n ≤ 10^5) — количество процессов.
2. В следующих n строках для каждого процесса i указано количество необходимых для его выполнения процессов \( a_i \), затем через пробел перечислены эти процессы — их номера.

### Формат выходных данных

1. В первой строке выведите число k — количество множеств, на которые необходимо разбить все процессы.
2. В следующих k строках выведите описание этих множеств: первым числом укажите размер множества \( k_i \), а далее через пробел \( k_i \) чисел в порядке возрастания — номера процессов очередного множества.

### Пример входных данных

