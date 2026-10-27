package interview.sortings;

/**


 JAVA 8 STREAM API - 200 INTERVIEW PRACTICE QUESTIONS
 20-Day Plan | 10 Questions per Day
 ==================================================================

 Day 1: Stream fundamentals and Lambda expressions
 -------------------------------------------------
 001. Print all elements using forEach().
 002. Filter even numbers using filter().
 003. Convert strings to uppercase using map().
 004. Count elements using count().
 005. Remove duplicates using distinct().
 006. Sort integers in ascending order using sorted().
 007. Sort integers in descending order.
 008. Find the first element using findFirst().
 009. Find any element using findAny().
 010. Check whether any number is greater than 50 using anyMatch().
 Practice Day 1

 Day 2: Filtering, mapping and primitive streams
 -----------------------------------------------
 011. Extract even numbers from a list.
 012. Extract odd numbers from a list.
 013. Square every number using map().
 014. Convert strings into their lengths.
 015. Convert numeric strings into integers.
 016. Sum numbers using mapToInt() and sum().
 017. Calculate average using average().
 018. Find maximum using max().
 019. Find minimum using min().
 020. Convert integers into strings.
 Practice Day 2

 Day 3: Sorting, Comparator and distinct values
 ----------------------------------------------
 021. Sort strings alphabetically.
 022. Sort strings by length.
 023. Sort employees by salary.
 024. Sort employees by department and then salary.
 025. Sort strings in reverse alphabetical order.
 026. Find the second-highest distinct number.
 027. Find the third-highest distinct number.
 028. Find the smallest three distinct numbers.
 029. Sort a list of dates.
 030. Sort employees by salary descending and name ascending.
 Practice Day 3

 Day 4: flatMap and nested collections
 -------------------------------------
 031. Flatten a list of lists into one list.
 032. Flatten a list of sets.
 033. Extract all words from a list of sentences.
 034. Flatten nested employee skill lists.
 035. Find all unique skills across employees.
 036. Flatten nested integer arrays.
 037. Convert strings into character streams.
 038. Flatten orders into line items.
 039. Extract unique product IDs from multiple orders.
 040. Explain map() versus flatMap() with examples.
 Practice Day 4

 Day 5: reduce and numeric operations
 ------------------------------------
 041. Sum integers using reduce().
 042. Multiply all numbers using reduce().
 043. Find maximum using reduce().
 044. Find minimum using reduce().
 045. Concatenate strings using reduce().
 046. Calculate factorial using reduce().
 047. Calculate total employee salary.
 048. Find the longest string using reduce().
 049. Calculate sum of squares.
 050. Explain identity, accumulator and combiner in reduce().
 Practice Day 5

 Day 6: Collecting results
 -------------------------
 051. Collect stream elements into a list.
 052. Collect unique elements into a set.
 053. Convert a list into a map using toMap().
 054. Handle duplicate keys while collecting a map.
 055. Create a map of employee ID to employee.
 056. Create a map of employee name to salary.
 057. Convert a stream into an array using toArray().
 058. Join strings using Collectors.joining().
 059. Collect into an unmodifiable collection using Java 8 techniques.
 060. Compare collect() and reduce().
 Practice Day 6

 Day 7: Grouping and aggregation
 -------------------------------
 061. Group employees by department.
 062. Count employees in each department.
 063. Find average salary by department.
 064. Find maximum salary in each department.
 065. Find minimum salary in each department.
 066. Calculate total salary by department.
 067. Group strings by length.
 068. Group words by their first character.
 069. Group transactions by year.
 070. Find the highest-paid employee in each department.
 Practice Day 7

 Day 8: Partitioning and advanced collectors
 -------------------------------------------
 071. Partition numbers into even and odd.
 072. Partition employees by a salary threshold.
 073. Use mapping() inside groupingBy().
 074. Use counting() inside groupingBy().
 075. Use summingInt() to total values by group.
 076. Use averagingInt() to calculate group averages.
 077. Use summarizingInt() for statistics.
 078. Use maxBy() inside a grouping collector.
 079. Use collectingAndThen() to transform a result.
 080. Compare groupingBy() and partitioningBy().
 Practice Day 8

 Day 9: Matching, finding and short-circuiting
 ---------------------------------------------
 081. Test whether all numbers are positive using allMatch().
 082. Test whether no strings are empty using noneMatch().
 083. Find the first employee matching a condition.
 084. Find any employee in a department.
 085. Find the first non-empty string.
 086. Check whether a list contains a target value.
 087. Validate that all employees meet a salary threshold.
 088. Check whether any employee has a null field.
 089. Explain short-circuiting terminal operations.
 090. Compare findFirst() and findAny().
 Practice Day 9

 Day 10: limit, skip and top-N problems
 --------------------------------------
 091. Find the top three highest numbers.
 092. Find the top five highest-paid employees.
 093. Implement pagination using skip() and limit().
 094. Find the second-lowest distinct number.
 095. Find the Nth-highest salary.
 096. Get the first five strings alphabetically.
 097. Skip the first three elements.
 098. Find the highest-paid three employees per department.
 099. Find the top two products by sales.
 100. Explain why sorting before limiting matters.
 Practice Day 10

 Day 11: Arrays and numeric streams
 ----------------------------------
 101. Convert an array into a stream.
 102. Convert an integer array into a list.
 103. Find the sum of an array using streams.
 104. Find the average of an array.
 105. Find duplicate numbers in an array.
 106. Find missing numbers in a range.
 107. Find common elements in two arrays.
 108. Find the intersection of two lists.
 109. Find the union of two lists.
 110. Calculate IntSummaryStatistics for an array.
 Practice Day 11

 Day 12: Stream creation and conversion
 --------------------------------------
 111. Create a stream using Stream.of().
 112. Create an empty stream using Stream.empty().
 113. Create a stream using Stream.builder().
 114. Generate values using Stream.generate().
 115. Generate a sequence using Stream.iterate().
 116. Create integer ranges using IntStream.range().
 117. Create inclusive ranges using rangeClosed().
 118. Convert an IntStream into a boxed stream.
 119. Convert IntStream to LongStream and DoubleStream.
 120. Concatenate two streams using Stream.concat().
 Practice Day 12

 Day 13: Maps, duplicate keys and collectors
 -------------------------------------------
 121. Find duplicate strings using groupingBy() and counting().
 122. Find elements that appear only once.
 123. Build a frequency map of integers.
 124. Build a frequency map of characters.
 125. Merge duplicate keys with toMap().
 126. Find the most frequent element.
 127. Find the least frequent element.
 128. Group employees by department and job title.
 129. Group employees and collect their names.
 130. Produce a department-to-average-salary map.
 Practice Day 13

 Day 14: Optional and null handling
 ----------------------------------
 131. Use Optional.ofNullable() safely.
 132. Use orElse() and orElseGet().
 133. Use orElseThrow() when a value is absent.
 134. Filter an Optional value.
 135. Transform an Optional using map().
 136. Chain Optional values using flatMap().
 137. Find maximum and handle an empty stream.
 138. Safely extract a nullable employee department.
 139. Avoid NullPointerException when processing names.
 140. Explain why Optional.get() should not be used blindly.
 Practice Day 14

 Day 15: String coding challenges
 --------------------------------
 141. Reverse a string using streams.
 142. Find the first non-repeated character.
 143. Find the first repeated character.
 144. Count occurrences of each character.
 145. Check whether two strings are anagrams.
 146. Find duplicate characters in a string.
 147. Find unique characters in a string.
 148. Count vowels and consonants.
 149. Find the longest word in a sentence.
 150. Find the most frequent word in a paragraph.
 Practice Day 15

 Day 16: Employee and business logic
 -----------------------------------
 151. Find the highest-paid employee.
 152. Find the second-highest-paid employee.
 153. Find the highest-paid employee in each department.
 154. Calculate average salary by department.
 155. Find employees earning above their department's average.
 156. Find the youngest employee in each department.
 157. Sort employees by multiple attributes.
 158. Find duplicate employee IDs.
 159. Convert employee lists into a department-to-employees map.
 160. Calculate payroll totals and statistics by department.
 Practice Day 16

 Day 17: Real-world collections problems
 ---------------------------------------
 161. Find common values between two lists.
 162. Remove duplicates while preserving encounter order.
 163. Find elements appearing in exactly one of two lists.
 164. Compare two maps and find differing entries.
 165. Merge two maps by summing duplicate values.
 166. Group orders by customer.
 167. Calculate total order value per customer.
 168. Find the customer with the highest spending.
 169. Extract unique products from customer orders.
 170. Rank products by sales amount.
 Practice Day 17

 Day 18: Parallel streams and internals
 --------------------------------------
 171. Compare stream() and parallelStream().
 172. Convert a stream to parallel using parallel().
 173. Convert a parallel stream to sequential using sequential().
 174. Explain forEach() versus forEachOrdered().
 175. Explain encounter order and unordered().
 176. Inspect elements with peek() for debugging.
 177. Explain lazy intermediate operations.
 178. Explain stateless versus stateful operations.
 179. Explain stream reuse and IllegalStateException.
 180. Identify unsafe shared mutable state in parallel streams.
 Practice Day 18

 Day 19: Complex multi-method challenges
 ---------------------------------------
 181. Find the second-highest salary per department.
 182. Find the top three salaries per department.
 183. Find the most common word in a list of sentences.
 184. Group anagrams together.
 185. Find pairs of numbers whose sum equals a target.
 186. Find the longest substring without duplicate characters.
 187. Find duplicate transactions by transaction ID.
 188. Group transactions by month and calculate totals.
 189. Find employees whose salaries exceed the overall average.
 190. Build a nested department-to-job-title employee count map.
 Practice Day 19

 Day 20: Mock interview and revision
 -----------------------------------
 191. Explain and implement filter(), map() and flatMap().
 192. Implement frequency counting without external libraries.
 193. Find the top three most frequent words.
 194. Find the Nth-highest distinct number.
 195. Group employees and find department salary statistics.
 196. Explain reduce() versus collect() with examples.
 197. Debug an incorrect stream pipeline.
 198. Refactor a loop-based program into a stream pipeline.
 199. Explain performance trade-offs in parallel streams.
 200. Solve an employee analytics problem in 15 minutes and explain time and space complexity.
 Practice Day 20

 END OF CHECKLIST


 */