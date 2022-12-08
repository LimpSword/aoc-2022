use std::collections::LinkedList;
use std::fs::File;
use std::io::{self, BufRead};
use std::path::Path;
use std::ptr::{null, null_mut};
use itertools::Itertools;
use std::time::{Duration, Instant};

fn main() {
    let list = parse();
    let start1 = Instant::now();
    part1(&list);
    let duration1 = start1.elapsed();

    let start2 = Instant::now();
    part2(&list);
    let duration2 = start2.elapsed();

    println!("[PART 1] Time elapsed: {:?}", duration1);
    println!("[PART 2] Time elapsed: {:?}", duration2);
}

fn parse() -> LinkedList<LinkedList<i32>> {
    if let Ok(lines) = read_lines("src/main/resources/day1") {
        let mut list = LinkedList::new();
        let mut current_list: LinkedList<i32> = LinkedList::new();
        for result in lines {
            if let Ok(line) = result {
                if line == "" {
                    list.push_front(current_list.clone());
                    current_list.clear();
                } else {
                    current_list.push_front(line.parse().unwrap());
                }
            }
        }
        return list;
    }
    return LinkedList::new();
}

fn part1(list: &LinkedList<LinkedList<i32>>) {
    let totals: _ = list.into_iter().map(|x| x.iter().sum::<i32>()).collect::<LinkedList<_>>();
    println!("{}", totals.iter().sorted().rev().take(3).sum::<i32>());
}

fn part2(list: &LinkedList<LinkedList<i32>>) {
    let totals: _ = list.into_iter().map(|x| x.iter().sum::<i32>()).collect::<LinkedList<_>>();
    println!("{}", totals.iter().sorted().rev().take(1).sum::<i32>());
}

fn read_lines<P>(filename: P) -> io::Result<io::Lines<io::BufReader<File>>>
    where P: AsRef<Path>, {
    let file = File::open(filename)?;
    Ok(io::BufReader::new(file).lines())
}