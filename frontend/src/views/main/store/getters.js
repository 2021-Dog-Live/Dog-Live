// getter

// 현재 로그인 된 UserInfo 가져오기
export function getLoginUserInfo(state) {
  return state.loginUserInfo
}

// 현재 Current Path 가져오기
export function getCurrentPath(state) {
  return state.currentPath
}

// 현재 Current Path Param 가져오기
export function getCurrentPathParam(state) {
  return state.currentPathParam
}
