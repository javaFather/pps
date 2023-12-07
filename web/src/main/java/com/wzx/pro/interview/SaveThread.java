package com.wzx.pro.interview;

public class SaveThread {
//    @Resource
//    SqlContext sqlContext;
//    /**
//     * 测试多线程事务.
//     * @param employeeDOList
//     */
//    @Override
//    public void saveThread(List<EmployeeDO> employeeDOList) throws SQLException {
//        // 获取数据库连接,获取会话(内部自有事务)
//        SqlSession sqlSession = sqlContext.getSqlSession();
//        Connection connection = sqlSession.getConnection();
//        try {
//            // 设置手动提交
//            connection.setAutoCommit(false);
//            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
//            //先做删除操作
//            employeeMapper.delete(null);
//            ExecutorService service = ExecutorConfig.getThreadPool();
//            List<Callable<Integer>> callableList  = new ArrayList<>();
//            List<List<EmployeeDO>> lists=averageAssign(employeeDOList, 5);
//            for (int i =0;i<lists.size();i++){
//                List<EmployeeDO> list  = lists.get(i);
//                Callable<Integer> callable = () -> employeeMapper.saveBatch(list);
//                callableList.add(callable);
//            }
//            //执行子线程
//            List<Future<Integer>> futures = service.invokeAll(callableList);
//            for (Future<Integer> future:futures) {
//                if (future.get()<=0){
//                    connection.rollback();
//                    return;
//                }
//            }
//            connection.commit();
//            System.out.println("添加完毕");
//        }catch (Exception e){
//            connection.rollback();
//            log.info("error",e);
//            throw new ServiceException("002","出现异常");
//            // throw new ServiceException(ExceptionCodeEnum.EMPLOYEE_SAVE_OR_UPDATE_ERROR);
//        }
//    }
}
